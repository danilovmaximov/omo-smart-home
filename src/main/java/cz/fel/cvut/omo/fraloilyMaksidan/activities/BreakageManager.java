package cz.fel.cvut.omo.fraloilyMaksidan.activities;

import cz.fel.cvut.omo.fraloilyMaksidan.sensors.observer.EventManager;

public class BreakageManager extends EventManager {
    public BreakageManager(String... operations) {
        super("Something's broken", operations);
    }

    public void notifyBreakage() {
        this.notifySubscribers("New breakage");
    }
}
