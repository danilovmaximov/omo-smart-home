package cz.fel.cvut.omo.fraloilyMaksidan.entities;

import cz.fel.cvut.omo.fraloilyMaksidan.activities.EventActivity;
import cz.fel.cvut.omo.fraloilyMaksidan.activities.interactions.BabyCry;
import cz.fel.cvut.omo.fraloilyMaksidan.activities.Activity;
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
        if (r.nextInt(5) == 1 && !isCrying) {
            this.isCrying = true;
        }
        return isCrying;
    }

    public void calmDown() {
        this.isCrying = false;
        if (currentActivity != null) {
            this.currentActivity.setBlocked(false);
        }
    }

    @Override
    public void step() {
        if(isCrying) { return; }
        if (maybeItIsTimeToMakeSomeNoise()) {
            if(currentActivity != null) {
                currentActivity.setBlocked(true);
            }
            generatedActivity = new BabyCry(4, this);
            room.setActivity(generatedActivity);
            eventManager.notifySubscribers(name);
        } else {
            super.step();
        }
    }
}

