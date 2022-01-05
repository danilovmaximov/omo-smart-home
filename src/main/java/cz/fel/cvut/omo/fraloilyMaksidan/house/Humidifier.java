package cz.fel.cvut.omo.fraloilyMaksidan.house;

import cz.fel.cvut.omo.fraloilyMaksidan.sensors.observer.Subscriber;

public class Humidifier implements Subscriber {
    private boolean isOn = false;

    private final int onHumidityChange = 3;
    private final int offHumidityChange = 0;

    public int getHumidityChange() {
        return isOn ? onHumidityChange : offHumidityChange;
    }

    @Override
    public void update(String event) {
        switch (event) {
            case "AirIsDry" -> isOn = true;
            case "AirIsWet" -> isOn = false;
        }
    }

    @Override
    public String toString() {
        return "Humidifier";
    }
}
