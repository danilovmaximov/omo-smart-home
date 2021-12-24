package cz.fel.cvut.omo.fraloilyMaksidan.entities.activities;

import cz.fel.cvut.omo.fraloilyMaksidan.Context;
import cz.fel.cvut.omo.fraloilyMaksidan.entities.LivingEntity;
import cz.fel.cvut.omo.fraloilyMaksidan.house.room.Room;
import cz.fel.cvut.omo.fraloilyMaksidan.reports.ActivityReporter;

abstract public class Activity {
    private final String name;
    private Room room;
    private final Context context = Context.getInstance();
    private int activityLength;

    private LivingEntity isUsing;
    private int currentStep = 0;

    public Activity(String name, int activityLength) {
        this.name = name;
        this.activityLength = activityLength;
    }

    public void moveToTheRoom(Room room) {
        this.room = room;
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
            System.out.println("New activity!");
            isUsing = entity;
            context.getReports().getActivityReporter().addToReports(entity, this);
        }
        if(currentStep == activityLength) {
            currentStep = 0;
            isUsing = null;
            System.out.println(entity + " finished with " + this + " in the " + room);
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
