package cz.fel.cvut.omo.fraloilyMaksidan.entities;

import cz.fel.cvut.omo.fraloilyMaksidan.activities.Activity;
import cz.fel.cvut.omo.fraloilyMaksidan.activities.EventActivity;
import cz.fel.cvut.omo.fraloilyMaksidan.activities.interactions.CleanUp;
import cz.fel.cvut.omo.fraloilyMaksidan.sensors.observer.EventManager;
import cz.fel.cvut.omo.fraloilyMaksidan.sensors.observer.Subscriber;

import java.util.*;

public class Cat extends LivingEntity implements Subscriber {
    private final EventManager eventManager;
    private EventActivity generatedActivity;
    private boolean justPissed = false;
    private final List<Dog> dogs = new ArrayList<>();

    public Cat(String name, List<Activity> activities) {
        super(name, activities);
        eventManager = new EventManager("Cat pees", name);
    }

    public void addDogs(Dog... dogs) {
        Collections.addAll(this.dogs, dogs);
        Arrays.stream(dogs).forEach(dog -> dog.addCatToFight(this));
    }

    public void addCleaner(Subscriber cleaner) {
        eventManager.subscribe(name, cleaner);
    }

    public void cleanedUp() {
        this.justPissed = false;
        if (currentActivity != null) {
            currentActivity.setBlocked(false);
        }
    }

    private boolean wannaPee() {
        Random r = new Random();
        if (r.nextInt(5) == 1) {
            this.justPissed = true;
        }
        return this.justPissed;
    }

    @Override
    public void step() {
        if (justPissed) {
            return;
        }
        if (wannaPee()) {
            if (currentActivity != null) {
                currentActivity.setBlocked(true);
            }
            generatedActivity = new CleanUp(this);
            room.setActivity(generatedActivity);
            eventManager.notifySubscribers(name);
        } else {
            super.step();
        }
    }

    @Override
    public void update(String event) {
        var fightingDog = dogs.stream()
                .filter(dog -> Objects.equals(event, dog.getName()))
                .toList().get(0);
        this.addEmergentActivity(fightingDog.getGeneratedActivity());
    }

    public EventActivity getGeneratedActivity() {
        return generatedActivity;
    }
}
