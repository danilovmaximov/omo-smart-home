package cz.fel.cvut.omo.fraloilyMaksidan.entities.activities;

import cz.fel.cvut.omo.fraloilyMaksidan.entities.LivingEntity;
import cz.fel.cvut.omo.fraloilyMaksidan.house.Room;
import cz.fel.cvut.omo.fraloilyMaksidan.reports.ActivityReporter;

abstract public class Activity {
    final String name;
    final Room room;
    final ActivityReporter reporter;
    int activityLength;

    LivingEntity isUsing;
    int currentStep = 0;

    public Activity(Room room, String name, int activityLength, ActivityReporter reporter) {
        this.name = name;
        this.room = room;
        this.reporter = reporter;
        this.activityLength = activityLength;
    }

    public void doActivity(LivingEntity entity) {
        if(isUsing != null && isUsing != entity) {
            System.out.println(
                    entity + " wanted to use " + this +
                            " but this is already in use by " + isUsing
            );
            entity.changeState();
            return;
        }
        if(currentStep == 0) {
            isUsing = entity;
            reporter.addToReports(isUsing, this);
        }
        if(currentStep == activityLength) {
            currentStep = 0;
            isUsing = null;
            entity.changeState();
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
