package cz.fel.cvut.omo.fraloilyMaksidan.house.room;

import cz.fel.cvut.omo.fraloilyMaksidan.house.MapContext;
import cz.fel.cvut.omo.fraloilyMaksidan.house.floor.Floor;

import cz.fel.cvut.omo.fraloilyMaksidan.entities.LivingEntity;
import cz.fel.cvut.omo.fraloilyMaksidan.activities.Activity;

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

    public String getName() {
        return this.name;
    }

    public void setFloor(Floor floor) { this.floor = floor; }

    public void setFloorByNum(int floorNum) { this.floor = MapContext.getFloorsInHouse().get(floorNum); }

    public void moveToFloor(Floor floor) {
        this.floor.removeRoom(this);
        this.floor = floor;
        floor.addRoom(this);
    }

    public Floor getFloor() { return this.floor; }

    public void setActivity(Activity activity) {
        this.activities.add(activity);
        activity.setRoom(this);
    }

    public void setActivityAll(Activity... activities) {
        Arrays.stream(activities)
                .forEach(this::setActivity);
    }

    public void setActivityList(List<Activity> activities) {
        activities.stream()
                .forEach(this::setActivity);
    }

    public void setEntity(LivingEntity entity) {
        this.entities.add(entity);
        entity.setRoom(this);
    }

    public void setEntitiesAll(LivingEntity... entities) {
        Arrays.stream(entities)
                .forEach(this::setEntity);
    }

    public void removeEntity(LivingEntity entity) {
        this.entities.remove(entity);
    }

    public void removeActivity(Activity activity) {
        this.activities.remove(activity);
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public List<LivingEntity> getEntities() {
        return entities;
    }

    public String entitiesConfiguration() {
        return Arrays.toString(entities.toArray());
    }

    @Override
    public String toString() {
        return name;
    }
}
