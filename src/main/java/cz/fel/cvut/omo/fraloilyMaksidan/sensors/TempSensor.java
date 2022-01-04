package cz.fel.cvut.omo.fraloilyMaksidan.sensors;

import cz.fel.cvut.omo.fraloilyMaksidan.Context;

public class TempSensor extends Sensor {
    boolean reportedOn = false;

    public TempSensor(String name, String... operations) {
        super(name, operations);
    }

    @Override
    public void step() {
        int tempLevel = Context.getTempLevel();
        if (tempLevel < 22 && !reportedOn) {
            reportedOn = true;
            this.notifySubscribers("Its cold");
        }
        if (tempLevel > 22 & reportedOn) {
            reportedOn = false;
            this.notifySubscribers("Its warm");
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
