package cz.fel.cvut.omo.fraloilyMaksidan.house.room;

import cz.fel.cvut.omo.fraloilyMaksidan.entities.LivingEntity;
import cz.fel.cvut.omo.fraloilyMaksidan.entities.activities.Activity;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;

public class Room {
    private String name;
    private List<Activity> activities = new ArrayList<>();
    private List<LivingEntity> entities = new ArrayList<>();

    public void setName(String name) {
        this.name = name;
    }

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

    @Override
    public String toString() {
        return name;
    }
}
