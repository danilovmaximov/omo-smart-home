package cz.fel.cvut.omo.fraloilyMaksidan.entities;

import cz.fel.cvut.omo.fraloilyMaksidan.entities.activities.Activity;
import cz.fel.cvut.omo.fraloilyMaksidan.reports.ActivityReporter;

import java.util.List;

public class Grandad extends LivingEntity {
    public Grandad(String name, List<Activity> activities) {
        super(name, activities);
    }
}
