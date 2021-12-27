package cz.fel.cvut.omo.fraloilyMaksidan.entities;

import cz.fel.cvut.omo.fraloilyMaksidan.entities.activities.staff.Activity;
import cz.fel.cvut.omo.fraloilyMaksidan.sensors.EventManager;
import cz.fel.cvut.omo.fraloilyMaksidan.sensors.Subscriber;
import jdk.jfr.Event;

import java.util.ArrayList;
import java.util.List;

public class Mom extends LivingEntity implements Subscriber {

    private Baby pizdiuk;

    public Mom(String name, Activity... activities) {
        super(name, List.of(activities));
    }

    public void addBaby(Baby pizdiuk) {
        this.pizdiuk = pizdiuk;
        pizdiuk.addSupervisor(this);
    }

    public void update(String event) {

    }
}
