package cz.fel.cvut.omo.fraloilyMaksidan.entities;

import cz.fel.cvut.omo.fraloilyMaksidan.entities.activities.interactions.EventActivity;
import cz.fel.cvut.omo.fraloilyMaksidan.entities.activities.staff.Activity;
import cz.fel.cvut.omo.fraloilyMaksidan.house.House;
import cz.fel.cvut.omo.fraloilyMaksidan.house.room.Room;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

abstract public class LivingEntity {
    protected final String name;
    private Activity currentActivity;
    protected House house;
    protected Room room;
    private final Deque<Activity> activities = new LinkedList<>();

    public LivingEntity(String name, Activity... activities) {
        this.name = name;
        Collections.addAll(this.activities, activities);
        nextActivity();
    }

    public void setRoom(Room room) {
        this.room = room;
        this.house = room.getFloor().getHouse();
    }

    public void addEmergentActivity(EventActivity activity) {
        this.activities.addFirst(activity);
    }

    public void reportBreakage(Activity activity) { this.house.addBrokenActivity(activity); }

    public void step() {
        Room activityRoom = this.currentActivity.getRoom();
        if(activityRoom != room) {
            this.room.removeEntity(this);
            System.out.println(this + " moving from  " + room + " to " + activityRoom);
            activityRoom.setEntity(this);
        }
        this.currentActivity.interactWithActivity(this);
    }

    public void nextActivity() {
        Activity nextActivity = activities.poll();
        // check if null but may be checked before
        if(currentActivity != null && !(currentActivity instanceof EventActivity)) {
            activities.add(currentActivity);
        }
        currentActivity = nextActivity;
    }

    @Override
    public String toString() {
        return name;
    }
}
