package cz.fel.cvut.omo.fraloilyMaksidan.entities;

import cz.fel.cvut.omo.fraloilyMaksidan.entities.activities.staff.Activity;
import cz.fel.cvut.omo.fraloilyMaksidan.house.House;
import cz.fel.cvut.omo.fraloilyMaksidan.house.room.Room;

import java.util.List;

abstract public class LivingEntity {
    private final String name;
    private Activity activity;
    protected House house;
    protected Room room;
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

    public void setRoom(Room room) {
        this.room = room;
        this.house = room.getFloor().getHouse();
    }

    public void reportBreakage(Activity activity) { this.house.addBrokenActivity(activity); }

    public void step() {
        Room activityRoom = this.activity.getRoom();
        if(activityRoom != room) {
            this.room.removeEntity(this);
            System.out.println(this + " moving from  " + room + " to " + activityRoom);
            activityRoom.setEntity(this);
        }
        this.activity.interactWithActivity(this);
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
