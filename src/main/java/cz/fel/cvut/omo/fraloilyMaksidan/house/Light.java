package cz.fel.cvut.omo.fraloilyMaksidan.house;

import cz.fel.cvut.omo.fraloilyMaksidan.sensors.observer.Subscriber;

public class Light implements Subscriber {
    boolean isOn = false;

    @Override
    public void update(String event) {
        switch (event) {
            case "LightDown" -> isOn = true;
            case "LightUp" -> isOn = false;
        }
    }

    @Override
    public String toString() {
        return "Light";
    }
}
