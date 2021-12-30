package cz.fel.cvut.omo.fraloilyMaksidan.entities;

import cz.fel.cvut.omo.fraloilyMaksidan.activities.Activity;
import cz.fel.cvut.omo.fraloilyMaksidan.sensors.Subscriber;

public class Father extends LivingEntity {
    public Father(String name, Activity... activities) {
        super(name, activities);
    }
}
