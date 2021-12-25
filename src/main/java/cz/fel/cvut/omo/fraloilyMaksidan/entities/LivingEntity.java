package cz.fel.cvut.omo.fraloilyMaksidan.entities;

import cz.fel.cvut.omo.fraloilyMaksidan.entities.activities.staff.Activity;
import cz.fel.cvut.omo.fraloilyMaksidan.house.House;

import java.util.List;

/**
 *
 */
abstract public class LivingEntity {
    private final String name;
    private Activity activity;
    protected House house;
    private final List<Activity> activities;
    private int currentActivity = 0;

    public LivingEntity(String name, List<Activity> activities) {
        this.name = name;
        this.activities = activities;
        this.testInstance();
        this.activity = activities.get(0);
    }

    private void testInstance() {
        if(name.isEmpty()) {
            throw new RuntimeException("Please add the name!");
        }
        if(this.activities.size() <= 0) {
            throw new RuntimeException(
                this.name +
                " have nothing to do. Please add at least one activity"
            );
        }
    }

    public void setHouse(House house) { this.house = house; }

    public void reportBreakage(Activity activity) { this.house.addBrokenActivity(activity); }

    public void step() {
        this.activity.doActivity(this);
    }

    public void changeState() {
        if(++this.currentActivity == this.activities.size()) {
            currentActivity = 0;
        }
        this.activity = activities.get(currentActivity);
    }

    @Override
    public String toString() {
        return name;
    }
}
