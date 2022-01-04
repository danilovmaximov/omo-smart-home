package cz.fel.cvut.omo.fraloilyMaksidan.sensors;

import cz.fel.cvut.omo.fraloilyMaksidan.Context;

public class SunSensor extends Sensor {
    boolean reportedUp = false;

    public SunSensor(String name, String... operations) {
        super(name, operations);
    }

    @Override
    public void step() {
        boolean isBright = Context.itsBright();
        if (isBright && !reportedUp) {
            reportedUp = true;
            this.notifySubscribers("LightUp");
        }
        if (!isBright & reportedUp) {
            reportedUp = false;
            this.notifySubscribers("LightDown");
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
