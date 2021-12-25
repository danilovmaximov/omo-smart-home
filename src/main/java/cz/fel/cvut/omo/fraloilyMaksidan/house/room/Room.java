package cz.fel.cvut.omo.fraloilyMaksidan.house.room;

import cz.fel.cvut.omo.fraloilyMaksidan.Configurable;
import cz.fel.cvut.omo.fraloilyMaksidan.house.floor.Floor;

import cz.fel.cvut.omo.fraloilyMaksidan.entities.LivingEntity;
import cz.fel.cvut.omo.fraloilyMaksidan.entities.activities.Activity;

import javax.swing.text.html.parser.Entity;
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

    public List<Activity> getActivities() {
        return activities;
    }

    public List<LivingEntity> getEntities() {
        return entities;
    }

    public void step() {
        for(LivingEntity e: entities) {
            e.step();
        }
    }

    public String entitiesConfiguration() {
        return Arrays.toString(entities.toArray());
    }

    @Override
    public String toString() {
        return name;
    }
}
