package cz.fel.cvut.omo.fraloilyMaksidan.sensors;

import cz.fel.cvut.omo.fraloilyMaksidan.Context;

public class HumiditySensor extends Sensor {
    boolean reportedOn = false;

    public HumiditySensor(String... operations) {
        super(operations);
        this.name = "Humidity sensor";
    }

    @Override
    public void step() {
        int humidityLevel = Context.getHumidityLevel();
        if (humidityLevel < 70 && !reportedOn) {
            reportedOn = true;
            this.notifySubscribers("AirIsDry");
        }
        if (humidityLevel > 70 && reportedOn) {
            reportedOn = false;
            this.notifySubscribers("AirIsWet");
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
