package cz.fel.cvut.omo.fraloilyMaksidan.sensors;

import cz.fel.cvut.omo.fraloilyMaksidan.Context;

public class SunSensor extends Sensor {
    private boolean reportedUp = false;

    public SunSensor(String name, String... operations) {
        super(name, operations);
    }

    @Override
    public void step() {
        boolean sunIsUp = Context.itsBright();
        if (sunIsUp && !reportedUp) {
            reportedUp = true;
            this.notifySubscribers("LightUp");
        }
        if (!sunIsUp & reportedUp) {
            reportedUp = false;
            this.notifySubscribers("LightDown");
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
