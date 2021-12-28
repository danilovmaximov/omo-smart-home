package cz.fel.cvut.omo.fraloilyMaksidan.activities.staff;

import cz.fel.cvut.omo.fraloilyMaksidan.Context;
import cz.fel.cvut.omo.fraloilyMaksidan.entities.LivingEntity;
import cz.fel.cvut.omo.fraloilyMaksidan.entities.enums.Durability;
import cz.fel.cvut.omo.fraloilyMaksidan.house.House;
import cz.fel.cvut.omo.fraloilyMaksidan.house.room.Room;

abstract public class Activity {
    private final String name;
    private final ActivityManual manual;
    private Room room;
    protected House house;

    private final Durability durability;
    private final int deterioration;
    private int condition = 100;

    private final int activityLength;
    private int currentStep = 0;
    protected LivingEntity isUsing;

    protected final Context context = Context.getInstance();

    public Activity(String name, int activityLength, Durability durability) {
        this.name = name;
        this.activityLength = activityLength;
        this.durability = durability;
        this.deterioration = this.durability.getDeterioration();

        if (this.durability == Durability.WEAK) this.manual = new ActivityManual(house, true);
        else this.manual = new ActivityManual(house, false);
    }

    public Room getRoom() {
        return this.room;
    }

    public void interactWithActivity(LivingEntity entity) {
        if(isUsing == entity) {return;}
        if(room.getEntities().contains(entity)) {
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
        this.house = room.getFloor().getHouse();
    }

    public void fixUp() { this.condition = 100; }
    public void getNew() { this.condition = 100; }

    public void step() {
        if(isIdle()) {
            System.out.println(this + " is idle.");
            manageIdle();
            return;
        }
        if (isBroken()) {
            System.out.println(isUsing + " wanted to use " + this + " but it is broken");
            isUsing.nextActivity();
            return;
        }
        if (isFinished()) {
            System.out.println(isUsing + " finished with " + this + " in the " + room);
            isUsing.nextActivity();
            // TODO Change this.
            if (isBroken()) {
                condition = 0;
                System.out.println(this + " has just broken, " + isUsing + " reports it");
                isUsing.reportBreakage(this);
            }
            //
            finishActivity();
            System.out.println(this + "'s current condition is " + condition + "%");
        } else {
            System.out.println(isUsing + " uses " + this + " in the " + room);
            manageStep();
        }
    }

    private boolean isIdle() {
        return isUsing == null;
    }

    private boolean inUseByOtherThen(LivingEntity entity) {
        return isUsing != null && isUsing != entity;
    }

    private void useActivityBy(LivingEntity entity) {
        this.isUsing = entity;
        context.getReports().getActivityReporter().addToReports(entity, this);
    }

    private boolean isFinished() {
        return currentStep == activityLength;
    }

    protected void manageIdle() {

    }

    protected void manageStep() {
        currentStep++;
    }

    private void finishActivity() {
        currentStep = 0;
        isUsing = null;
        condition -= deterioration;
    }

    @Override
    public String toString() {
        return name;
    }
}
