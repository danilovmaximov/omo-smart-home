package cz.fel.cvut.omo.fraloilyMaksidan.sensors;

import cz.fel.cvut.omo.fraloilyMaksidan.Context;
import cz.fel.cvut.omo.fraloilyMaksidan.Iterable;

public class SunSensor extends Sensor {
    String name = "SunSensor";
    boolean reportedUp;

    public SunSensor(String... operations) {
        super(operations);
        this.name = name;
        this.reportedUp = false;
    }

    @Override
    public void step() {
        int lightLevel = Context.getLightLevel();
        //TODO: Add logic here;
        if(lightLevel > 90 && !reportedUp) {
            reportedUp = true;
            this.notifySubscribers("LightUp");
        }

        if(lightLevel < 90 & reportedUp) {
            reportedUp = false;
            this.notifySubscribers("LightDown");
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
