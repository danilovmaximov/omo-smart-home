package cz.fel.cvut.omo.fraloilyMaksidan.entities;

import cz.fel.cvut.omo.fraloilyMaksidan.entities.activities.interactions.EventActivity;
import cz.fel.cvut.omo.fraloilyMaksidan.entities.activities.appliances.CoffeeMaker;
import cz.fel.cvut.omo.fraloilyMaksidan.entities.activities.interactions.BabyCry;
import cz.fel.cvut.omo.fraloilyMaksidan.entities.activities.staff.Play;
import cz.fel.cvut.omo.fraloilyMaksidan.entities.activities.staff.Sleep;
import cz.fel.cvut.omo.fraloilyMaksidan.sensors.EventManager;
import cz.fel.cvut.omo.fraloilyMaksidan.sensors.Subscriber;

import java.util.Random;

public class Baby extends LivingEntity {
    private EventManager eventManager;
    private Random r = new Random();
    private boolean isCrying = false;
    private EventActivity generatedActivity = new BabyCry(r.nextInt(5), this);

    public Baby(String name, int sleepStep, int playStep) {
        super(name,
                new Sleep(sleepStep),
                new Play(playStep)
        );
        eventManager = new EventManager(name);
    }

    public EventActivity getGeneratedActivity() {
        return generatedActivity;
    }

    public void addSupervisor(Subscriber childSupervisor) {
        eventManager.subscribe(this.name, childSupervisor);
    }

    private boolean maybeItIsTimeToMakeSomeNoise() {
        if(r.nextInt(10) == 7 && !isCrying) {
            this.isCrying = true;
        }
        return isCrying;
    }

    @Override
    public void step() {
        if(maybeItIsTimeToMakeSomeNoise()) {
            eventManager.notifySubscribers(name);
        } else {
            super.step();
        }
    }
}

