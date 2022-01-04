package cz.fel.cvut.omo.fraloilyMaksidan.sensors;

import cz.fel.cvut.omo.fraloilyMaksidan.sensors.observer.EventManager;

abstract public class Sensor extends EventManager {
    protected final String name;

    public Sensor(String name, String... operations) {
        super(name, operations);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    abstract void step();
}
