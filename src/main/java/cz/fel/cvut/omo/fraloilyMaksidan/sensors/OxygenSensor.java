package cz.fel.cvut.omo.fraloilyMaksidan.sensors;

import cz.fel.cvut.omo.fraloilyMaksidan.Context;

public class OxygenSensor extends Sensor {
    String name = "Oxygen level sensor";
    boolean reportedClose = false;

    public OxygenSensor(String... operations) {
        super(operations);
    }

    @Override
    public void step() {
        int oxygenLevel = Context.getOxygenLevel();
        if (oxygenLevel < 80 && reportedClose) {
            reportedClose = false;
            this.notifySubscribers("OxygenLow");
        }
        if (oxygenLevel > 80 && !reportedClose) {
            reportedClose = true;
            this.notifySubscribers("OxygenHigh");
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
