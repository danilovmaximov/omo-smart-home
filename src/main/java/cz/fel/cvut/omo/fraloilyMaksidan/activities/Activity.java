package cz.fel.cvut.omo.fraloilyMaksidan.activities;

import cz.fel.cvut.omo.fraloilyMaksidan.Context;
import cz.fel.cvut.omo.fraloilyMaksidan.activities.staff.ActivityManual;
import cz.fel.cvut.omo.fraloilyMaksidan.entities.LivingEntity;
import cz.fel.cvut.omo.fraloilyMaksidan.enums.Durability;
import cz.fel.cvut.omo.fraloilyMaksidan.house.room.Room;

abstract public class Activity {
    private final String name;
    private ActivityManual manual;
    private Room room;

    private final Durability durability;
    private final int deterioration;
    private int condition = 100;

    private final int activityLength;
    private int currentStep = 0;
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

    public Room getRoom() {
        return this.room;
    }

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

    public void step() {
        if (isBlocked()) {
            System.out.println(isUsing + " is interrupted from " + this);
            return;
        }
        if (isIdle()) {
            manageIdle();
            return;
        }
        if (isBroken()) {
            isUsing.nextActivity();
            finishActivity();
            System.out.println(isUsing + " wanted to use " + this + " but it is broken");
            return;
        }
        if (isFinished()) {
            System.out.println(isUsing + " finished with " + this + " in the " + room);
            isUsing.nextActivity();
            condition -= deterioration;
            if (isBroken()) {
                this.condition = 0;
                System.out.println(this + " has just broken, " + isUsing + " reports it");
                isUsing.reportBrokenActivity(this);
            }
            finishActivity();
            if (this.durability != durability.UNBREAKABLE) {
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
        Context.getReports().getActivityReporter().addToReports(entity, this.toString(), "Done");
    }

    private boolean isFinished() {
        return currentStep == activityLength;
    }

    protected void manageIdle() {

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
