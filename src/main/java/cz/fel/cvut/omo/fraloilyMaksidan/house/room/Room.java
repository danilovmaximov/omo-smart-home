package cz.fel.cvut.omo.fraloilyMaksidan.house.room;

import cz.fel.cvut.omo.fraloilyMaksidan.Context;
import cz.fel.cvut.omo.fraloilyMaksidan.house.floor.Floor;

import cz.fel.cvut.omo.fraloilyMaksidan.entities.LivingEntity;
import cz.fel.cvut.omo.fraloilyMaksidan.activities.staff.Activity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Room {
    private String name;
    private Floor floor;
    private List<Activity> activities = new ArrayList<>();
    private List<LivingEntity> entities = new ArrayList<>();

    public void setName(String name) {
        this.name = name;
    }


    public void setFloor(Floor floor) { this.floor = floor; }

    public Floor getFloor() { return this.floor; }

    public void setActivity(Activity activity) {
        this.activities.add(activity);
        activity.setRoom(this);
    }

    public void setEntity(LivingEntity entity) {
        this.entities.add(entity);
        entity.setRoom(this);
    }

    public void removeEntity(LivingEntity entity) {
        this.entities.remove(entity);
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public List<LivingEntity> getEntities() {
        return entities;
    }

    public void step() {
        System.out.println("Step in room " + name);
        Context.moveEntities();
        activities.forEach(Activity::step);
    }

    public String entitiesConfiguration() {
        return Arrays.toString(entities.toArray());
    }

    @Override
    public String toString() {
        return name;
    }
}
