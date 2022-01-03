package cz.fel.cvut.omo.fraloilyMaksidan.sensors;

import cz.fel.cvut.omo.fraloilyMaksidan.Context;

public class TempSensor extends Sensor {
    boolean reportedOn = false;

    public TempSensor(String... operations) {
        super(operations);
        this.name = "Inside temperature sensor";
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
