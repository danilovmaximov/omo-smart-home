package cz.fel.cvut.omo.fraloilyMaksidan.sensors;

import cz.fel.cvut.omo.fraloilyMaksidan.Iterable;

abstract public class Sensor extends EventManager implements Iterable {
    protected String name;

    public Sensor(String... operations) {
        super(operations);
    }

    public String getName() {
        return this.name;
    }
}
