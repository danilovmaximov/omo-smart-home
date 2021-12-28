package cz.fel.cvut.omo.fraloilyMaksidan.entities;

import cz.fel.cvut.omo.fraloilyMaksidan.activities.interactions.EventActivity;
import cz.fel.cvut.omo.fraloilyMaksidan.activities.interactions.BabyCry;
import cz.fel.cvut.omo.fraloilyMaksidan.activities.staff.Activity;
import cz.fel.cvut.omo.fraloilyMaksidan.sensors.EventManager;
import cz.fel.cvut.omo.fraloilyMaksidan.sensors.Subscriber;

import java.util.Random;

public class Baby extends LivingEntity {
    private EventManager eventManager;
    private Random r = new Random();
    private boolean isCrying = false;
    private EventActivity generatedActivity;

    public Baby(String name, Activity... activities) {
        super(name, activities);
        eventManager = new EventManager(name);
    }

    public EventActivity getGeneratedActivity() {
        return generatedActivity;
    }

    public void addSupervisor(Subscriber childSupervisor) {
        eventManager.subscribe(this.name, childSupervisor);
    }

    private boolean maybeItIsTimeToMakeSomeNoise() {
        if (r.nextInt(10) == 7 && !isCrying) {
            this.isCrying = true;
        }
        return isCrying;
    }

    @Override
    public void step() {
        System.out.println(this + " current activity: " + currentActivity);
        if(isCrying) {return;}
        if (maybeItIsTimeToMakeSomeNoise()) {
            generatedActivity = new BabyCry(4, this);
            room.setActivity(generatedActivity);
            eventManager.notifySubscribers(name);
        } else {
            super.step();
        }
    }
}

