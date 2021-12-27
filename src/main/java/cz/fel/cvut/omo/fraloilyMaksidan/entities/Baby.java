package cz.fel.cvut.omo.fraloilyMaksidan.entities;

import cz.fel.cvut.omo.fraloilyMaksidan.sensors.EventManager;
import cz.fel.cvut.omo.fraloilyMaksidan.sensors.Subscriber;

import java.util.List;

public class Baby extends LivingEntity {
    private final String event = "Triggered";
    EventManager babyEvents;

    public Baby(String name) {
        super(name, List.of(
                // Sleep, eat, shit
        ));
    }

    public void addSupervisor(Subscriber childSupervisor) {
        babyEvents.subscribe(event, childSupervisor);
    }


}

