package cz.fel.cvut.omo.fraloilyMaksidan.entities;

import cz.fel.cvut.omo.fraloilyMaksidan.Context;
import cz.fel.cvut.omo.fraloilyMaksidan.activities.EventActivity;
import cz.fel.cvut.omo.fraloilyMaksidan.activities.Activity;
import cz.fel.cvut.omo.fraloilyMaksidan.activities.contextmodifiers.ContextModifierActivity;
import cz.fel.cvut.omo.fraloilyMaksidan.house.MapContext;
import cz.fel.cvut.omo.fraloilyMaksidan.house.room.Room;

import java.util.*;

abstract public class LivingEntity {
    protected final String name;
    protected Activity currentActivity;
    protected Room room;
    protected final Deque<Activity> activities = new LinkedList<>();
    protected boolean isAway = false;

    public LivingEntity(String name, List<Activity> activities) {
        this.name = name;
        activities.forEach(this.activities::addFirst);
        MapContext.addEntity(this);
    }

    public String getName() {
        return this.name;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setAway(boolean isAway) {
        this.isAway = isAway;
    }

    public void reportBrokenActivity(Activity activity) {
        Context.addBrokenActivity(activity);
        MapContext.getBreakageManager().notifyBreakage();
    }

    public void addEmergentActivity(Activity activity) {
        this.activities.addFirst(activity);
    }

    public void step() {
        if (currentActivity == null) {
            nextActivity();
        }
        if (currentActivity == null) {
            System.out.println("Ну привет ебать");
            for (Activity activity : activities) {
                System.out.println("   " + activity);
            }
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
