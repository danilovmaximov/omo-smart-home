package cz.fel.cvut.omo.fraloilyMaksidan.activities;

import cz.fel.cvut.omo.fraloilyMaksidan.Context;
import cz.fel.cvut.omo.fraloilyMaksidan.activities.staff.ActivityManual;
import cz.fel.cvut.omo.fraloilyMaksidan.entities.LivingEntity;
import cz.fel.cvut.omo.fraloilyMaksidan.enums.Durability;
import cz.fel.cvut.omo.fraloilyMaksidan.house.room.Room;

/**
 * Activity template. Derived classes could override particular methods to add functionality.
 */
abstract public class Activity {
    private final String name;
    private final ActivityManual manual;
    protected String standardRoomName;
    private Room room;

    private final Durability durability;
    private final int deterioration;
    private int condition = 100;

    private final int activityLength;
    protected int currentStep = 0;
    protected LivingEntity isUsing;
    private boolean blocked = false;

    public Activity(String name, int activityLength, Durability durability) {
        this.name = name;
        this.activityLength = activityLength;
        this.durability = durability;
        this.deterioration = this.durability.getDeterioration();
        if (this.durability == Durability.WEAK || this.durability == Durability.NORMAL) {
            this.manual = new ActivityManual(true);
        } else {
            this.manual = new ActivityManual(false);
        }
    }

    public String getName() {
        return this.name;
    }

    public Room getRoom() {
        return this.room;
    }

    public String getStandardRoomName() {
        return this.standardRoomName;
    }

    /**
     * @param entity
     * Entity sets itself for the activity.
     */
    public void interactWithActivity(LivingEntity entity) {
        if (isUsing == entity) { return; }
        if (room.getEntities().contains(entity)) {
            if (inUseByOtherThen(entity)) {
                System.out.println(entity + " wanted to use " + this + " but this is already in use by " + isUsing);
                entity.nextActivity();
            } else {
                System.out.println(entity + " started using " + this);
                useActivityBy(entity);
            }
        } else {
            System.out.println(entity + " is moving to the room, where " + this + " is placed.");
        }
    }

    private boolean isBroken() {
        return this.condition <= 0;
    }
    public ActivityManual getManual() { return this.manual; }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void fixUp() {
        System.out.println(this + "is fixed");
        this.condition = 80;
    }
    public void getNew() {
        System.out.println(this + "was changed for new");
        this.condition = 100;
    }


    /**
     * Changes state of the activity. Makes one step.
     */
    public void step() {
        if (isBlocked()) {
            System.out.println(isUsing + " is interrupted from " + this);
        } else if (isIdle()) {
            manageIdle();
        } else if (isBroken()) {
            isUsing.nextActivity();
            finishActivity();
            System.out.println(isUsing + " wanted to use " + this + " but it is broken");
        } else if (isFinished()) {
            System.out.println(isUsing + " finished with " + this + " in the " + room);
            isUsing.nextActivity();
            condition -= deterioration;
            if (isBroken()) {
                this.condition = 0;
                System.out.println(this + " has just broken, " + isUsing + " reports it");
                isUsing.reportBrokenActivity(this);
            }
            finishActivity();
            if (this.durability != Durability.UNBREAKABLE) {
                System.out.println(this + "'s current condition is " + this.condition + "%");
            }
        } else {
            System.out.println(isUsing + " uses " + this + " in the " + room);
            manageStep();
        }
    }

    private boolean isIdle() { return isUsing == null; }

    private boolean inUseByOtherThen(LivingEntity entity) {
        return isUsing != null && isUsing != entity;
    }

    protected void useActivityBy(LivingEntity entity) {
        this.isUsing = entity;
        Context.getReports().getActivityReporter().addToReports(entity, this.toString(), "Done", activityLength);
    }

    private boolean isFinished() {
        return currentStep == activityLength;
    }

    protected void manageIdle() {
        // add
    }

    protected void manageStep() {
        currentStep++;
    }

    protected void finishActivity() {
        currentStep = 0;
        isUsing = null;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    @Override
    public String toString() {
        return name;
    }
}
