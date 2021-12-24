package cz.fel.cvut.omo.fraloilyMaksidan.entities.activities;

import cz.fel.cvut.omo.fraloilyMaksidan.Context;
import cz.fel.cvut.omo.fraloilyMaksidan.entities.LivingEntity;
import cz.fel.cvut.omo.fraloilyMaksidan.house.House;
import cz.fel.cvut.omo.fraloilyMaksidan.house.room.Room;
import cz.fel.cvut.omo.fraloilyMaksidan.reports.ActivityReporter;

enum Durability {
    UNBREAKABLE(0), STRONG(5), NORMAL(10), WEAK(20);

    private int deter; // deterioration
    Durability(int det) {
        this.deter = det;
    }
    public int getDeterioration() {
        return this.deter;
    }
}

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

    private final Context context = Context.getInstance();

    public Activity(String name, int activityLength, Durability durability) {
        this.name = name;
        this.activityLength = activityLength;
        this.durability = durability;
        this.deterioration = this.durability.getDeterioration();
    }

    private boolean isBroken() { return this.condition <= 0; }
    public void moveToTheRoom(Room room) {
        this.room = room;
        this.house = room.getFloor().getHouse();
    }
    public void fixUp() { this.condition = 100; }

    public void doActivity(LivingEntity entity) {
        if (isUsing != null && isUsing != entity) {
            System.out.println(entity + " wanted to use " + this + " but this is already in use by " + isUsing);
            entity.changeState();
            return;
        }
        if (this.isBroken()) {
            System.out.println(entity + " wanted to use " + this + " but it is broken");
            entity.changeState();
            return;
        }
        if (currentStep == 0) {
            System.out.println("New activity: " + this);
            isUsing = entity;
            context.getReports().getActivityReporter().addToReports(entity, this);
        }
        if (currentStep == activityLength) {
            currentStep = 0;
            isUsing = null;
            System.out.println(entity + " finished with " + this + " in the " + room);
            entity.changeState();

            condition -= deterioration;
            if (this.isBroken()) {
                condition = 0;
                System.out.println(this + " has just broken, " + entity + " reports it");
                entity.reportBreakage(this);
            }
            System.out.println(this + "'s current condition is " + condition + "%");
            return;
        } else {
            System.out.println(entity + " uses " + this + " in the " + room);
            currentStep++;
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
