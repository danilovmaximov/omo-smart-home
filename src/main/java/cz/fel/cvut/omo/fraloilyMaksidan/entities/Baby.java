package cz.fel.cvut.omo.fraloilyMaksidan.entities;

import cz.fel.cvut.omo.fraloilyMaksidan.senzors.EventManager;
import cz.fel.cvut.omo.fraloilyMaksidan.senzors.Subscriber;

import java.util.List;

public class Baby extends LivingEntity {
    private final String event = "Triggerd";
    EventManager babyEvents = new EventManager(event);

    public Baby(String name, Subscriber... supervisors) {
        super(name, List.of(
                // Sleep, eat, shit
        ));
    }

    public void addSupervisor(Subscriber childSupervisor) {
        babyEvents.subscribe(event, childSupervisor);
    }





}
