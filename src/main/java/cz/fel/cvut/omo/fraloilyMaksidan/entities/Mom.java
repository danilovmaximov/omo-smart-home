package cz.fel.cvut.omo.fraloilyMaksidan.entities;

import cz.fel.cvut.omo.fraloilyMaksidan.entities.activities.staff.Activity;
import cz.fel.cvut.omo.fraloilyMaksidan.senzors.Subscriber;

import java.util.List;

public class Mom extends LivingEntity implements Subscriber {

    public Mom(String name, Activity... activities) {
        super(name, List.of(activities));
    }

    public void update(String event) {

    }
}
