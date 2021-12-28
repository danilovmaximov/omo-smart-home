package cz.fel.cvut.omo.fraloilyMaksidan.sensors;

import cz.fel.cvut.omo.fraloilyMaksidan.Iterable;

public class Sensor extends EventManager implements Iterable {

    public Sensor(String... operations) {
        super(operations);
    }

    @Override
    public void step() {

    }
}
