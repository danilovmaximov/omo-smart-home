package cz.fel.cvut.omo.fraloilyMaksidan.house;

import cz.fel.cvut.omo.fraloilyMaksidan.sensors.observer.Subscriber;

public class Humidifier implements Subscriber {
    boolean isWorking = false;

    @Override
    public void update(String event) {
        switch (event) {
            case "AirIsDry" -> isWorking = true;
            case "AirIsWet" -> isWorking = false;
        }
    }

    @Override
    public String toString() {
        return "Humidifier is working: " + isWorking;
    }
}
