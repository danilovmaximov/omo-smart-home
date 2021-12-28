package cz.fel.cvut.omo.fraloilyMaksidan.entities;

import cz.fel.cvut.omo.fraloilyMaksidan.Context;
import cz.fel.cvut.omo.fraloilyMaksidan.activities.interactions.EventActivity;
import cz.fel.cvut.omo.fraloilyMaksidan.activities.staff.Activity;
import cz.fel.cvut.omo.fraloilyMaksidan.house.House;
import cz.fel.cvut.omo.fraloilyMaksidan.house.room.Room;
import cz.fel.cvut.omo.fraloilyMaksidan.reports.ActivityReporter;

import java.lang.reflect.Array;
import java.util.*;

abstract public class LivingEntity {
    protected final String name;
    protected Activity currentActivity;
    protected Room room;
    private final Deque<Activity> activities = new LinkedList<>();

    public LivingEntity(String name, Activity... activities) {
        this.name = name;
        Collections.addAll(this.activities, activities);
        this.currentActivity = List.of(activities).get(0);
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void reportBrokenActivity(Activity activity) {
        Context.addBrokenActivity(activity);
    }

    public void addEmergentActivity(EventActivity activity) {
        this.activities.addFirst(activity);
    }

    public void step() {
        System.out.println("======= Queue " + this + " =========");
        activities.forEach(activity -> System.out.print(activity + " "));
        System.out.println();
        Room activityRoom = this.currentActivity.getRoom();
        if (activityRoom != room) {
            this.room.removeEntity(this);
            System.out.println(this + " moving from  " + room + " to " + activityRoom);
            activityRoom.setEntity(this);
        }
        this.currentActivity.interactWithActivity(this);
    }

    public void nextActivity() {
        // check if null but may be checked before
        if (!(currentActivity instanceof EventActivity)) {
            activities.addLast(currentActivity);
        }
        currentActivity = activities.pollFirst();
    }

    @Override
    public String toString() {
        return name;
    }
}
