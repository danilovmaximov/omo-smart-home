package cz.fel.cvut.omo.fraloilyMaksidan.sensors;

import cz.fel.cvut.omo.fraloilyMaksidan.Context;

public class TempSensor extends Sensor {
    String name = "Inside temperature sensor";
    boolean reportedOn = false;

    public TempSensor(String... operations) {
        super(operations);
    }

    @Override
    public void step() {
        int tempLevel = Context.getTempLevel();
        if (tempLevel < 22 && !reportedOn) {
            reportedOn = true;
            this.notifySubscribers("ItsCold");
        }
        if (tempLevel > 22 & reportedOn) {
            reportedOn = false;
            this.notifySubscribers("ItsWarm");
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
