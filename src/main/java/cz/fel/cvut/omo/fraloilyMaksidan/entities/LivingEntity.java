package cz.fel.cvut.omo.fraloilyMaksidan.entities;

import cz.fel.cvut.omo.fraloilyMaksidan.Context;
import cz.fel.cvut.omo.fraloilyMaksidan.activities.EventActivity;
import cz.fel.cvut.omo.fraloilyMaksidan.activities.Activity;
import cz.fel.cvut.omo.fraloilyMaksidan.activities.contextmodifiers.ContextModifierActivity;
import cz.fel.cvut.omo.fraloilyMaksidan.enums.ExistingActivities;
import cz.fel.cvut.omo.fraloilyMaksidan.house.MapContext;
import cz.fel.cvut.omo.fraloilyMaksidan.house.room.Room;
import cz.fel.cvut.omo.fraloilyMaksidan.reports.ActivityReporter;

import java.lang.reflect.Array;
import java.util.*;

abstract public class LivingEntity {
    protected final String name;
    protected Activity currentActivity;
    protected Room room;
    protected final Deque<Activity> activities = new LinkedList<>();

    public LivingEntity(String name, List<ExistingActivities> standard_activities) {
        this.name = name;
        for (ExistingActivities standardActivity : standard_activities) {
            for (Activity existingActivity : MapContext.getActivitiesInHouse()) {
                if (standardActivity.getName() == existingActivity.getName()) {
                    this.activities.addFirst(existingActivity);
                }
            }
        }
        MapContext.addEntity(this);
    }

    public LivingEntity(String name, Activity... activities) {
        this.name = name;
        Arrays.stream(activities).forEach(activity -> this.activities.addFirst(activity));
        MapContext.addEntity(this);
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void reportBrokenActivity(Activity activity) {
        Context.addBrokenActivity(activity);
    }

    public void addEmergentActivity(Activity activity) {
        this.activities.addFirst(activity);
    }

    public void step() {
        if(currentActivity == null) {
            nextActivity();
        }

        Room activityRoom = this.currentActivity.getRoom();
        if (activityRoom != room) {
            this.room.removeEntity(this);
            System.out.println(this + " moving from  " + room + " to " + activityRoom);
            activityRoom.setEntity(this);
        }
        this.currentActivity.interactWithActivity(this);
    }

    public void nextActivity() {
        currentActivity = activities.pollFirst();
         System.out.println(currentActivity);
        if (!(currentActivity instanceof EventActivity) && !(currentActivity instanceof ContextModifierActivity)) {
            activities.addLast(currentActivity);
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
