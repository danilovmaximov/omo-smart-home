package cz.fel.cvut.omo.fraloilyMaksidan.entities.activities.staff;

import cz.fel.cvut.omo.fraloilyMaksidan.Context;
import cz.fel.cvut.omo.fraloilyMaksidan.entities.LivingEntity;
import cz.fel.cvut.omo.fraloilyMaksidan.entities.enums.Durability;
import cz.fel.cvut.omo.fraloilyMaksidan.house.House;
import cz.fel.cvut.omo.fraloilyMaksidan.house.room.Room;

abstract public class Activity {
    private final String name;
    private Room room;
    protected House house;

    private Durability durability;
    private int deterioration;
    private int condition = 100;

    private int activityLength;
    private int currentStep = 0;
    private LivingEntity isUsing;

    protected final Context context = Context.getInstance();

    public Activity(String name, int activityLength, Durability durability) {
        this.name = name;
        this.activityLength = activityLength;
        this.durability = durability;
        this.deterioration = this.durability.getDeterioration();
    }

    private boolean isBroken() {
        return this.condition <= 0;
    }

    public void moveToTheRoom(Room room) {
        this.room = room;
        this.house = room.getFloor().getHouse();
    }

    public void fixUp() {
        this.condition = 100;
    }

    public void doActivity(LivingEntity entity) {
        if (inUseByOtherThen(entity)) {
            System.out.println(entity + " wanted to use " + this + " but this is already in use by " + isUsing);
            entity.changeState();
            return;
        }
        if (isBroken()) {
            System.out.println(entity + " wanted to use " + this + " but it is broken");
            entity.changeState();
            return;
        }
        if (isNewActivity()) {
            System.out.println("New activity: " + this);
            useActivityBy(entity);
        }

        if (activityIsFinished()) {
            finishActivity();
            System.out.println(entity + " finished with " + this + " in the " + room);
            entity.changeState();
            //TODO Change this.
            if (isBroken()) {
                condition = 0;
                System.out.println(this + " has just broken, " + entity + " reports it");
                entity.reportBreakage(this);
            }
            //
            System.out.println(this + "'s current condition is " + condition + "%");
            return;
        } else {
            System.out.println(entity + " uses " + this + " in the " + room);
            manageState();
        }
    }

    private boolean inUseByOtherThen(LivingEntity entity) {
        return isUsing != null && isUsing != entity;
    }

    private boolean isNewActivity() {
        return currentStep == 0;
    }

    private void useActivityBy(LivingEntity entity) {
        this.isUsing = entity;
        context.getReports().getActivityReporter().addToReports(entity, this);
    }

    private boolean activityIsFinished() {
        return currentStep == activityLength;
    }

    protected void manageState() {
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
