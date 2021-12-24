package cz.fel.cvut.omo.fraloilyMaksidan.entities;

import cz.fel.cvut.omo.fraloilyMaksidan.entities.activities.Activity;
import cz.fel.cvut.omo.fraloilyMaksidan.entities.activities.CoffeeMaker;
import cz.fel.cvut.omo.fraloilyMaksidan.reports.ActivityReporter;

import java.util.List;

/**
 *
 */
abstract public class LivingEntity {
    private final String name;
    private Activity activity;
    private final List<CoffeeMaker> activities;
    int currentActivity = 0;
    private ActivityReporter rp;

    public LivingEntity(String name, List<CoffeeMaker> activities, ActivityReporter rp) {
        this.name = name;
        this.activities = activities;
        this.rp = rp;
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
