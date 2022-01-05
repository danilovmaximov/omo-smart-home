package cz.fel.cvut.omo.fraloilyMaksidan.entities;

import cz.fel.cvut.omo.fraloilyMaksidan.activities.Activity;
import cz.fel.cvut.omo.fraloilyMaksidan.activities.EventActivity;
import cz.fel.cvut.omo.fraloilyMaksidan.activities.interactions.AnimalFight;
import cz.fel.cvut.omo.fraloilyMaksidan.sensors.observer.EventManager;
import cz.fel.cvut.omo.fraloilyMaksidan.sensors.observer.Subscriber;

import java.util.List;
import java.util.Random;

public class Dog extends LivingEntity {
    private final EventManager eventManager;
    private EventActivity generatedActivity;
    boolean isFighting = false;

    public Dog(String name, List<Activity> activities) {
        super(name, activities);
        eventManager = new EventManager("Dog fights", name);
    }

    public void addCatToFight(Subscriber cat) {
        eventManager.subscribe(name, cat);
    }

    private boolean fightingIsFun() {
        Random r = new Random();
        if (r.nextInt(5) == 1) {
            this.isFighting = true;
        }
        return this.isFighting;
    }

    public void stopFighting() {
        this.isFighting = false;
        if (currentActivity != null) {
            currentActivity.setBlocked(false);
        }
    }

    @Override
    public void step() {
        if (isFighting) {
            return;
        }
        if (fightingIsFun()) {
            if (currentActivity != null) {
                currentActivity.setBlocked(true);
            }
            generatedActivity = new AnimalFight(this);
            room.setActivity(generatedActivity);
            eventManager.notifySubscribers(name);
        } else {
            super.step();
        }
    }

    public EventActivity getGeneratedActivity() {
        return generatedActivity;
    }
}
