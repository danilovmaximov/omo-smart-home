package cz.fel.cvut.omo.fraloilyMaksidan.house;
import cz.fel.cvut.omo.fraloilyMaksidan.sensors.observer.Subscriber;

public class Window implements Subscriber {
    boolean closedShutters = false;
    boolean closedWindow = false;

    @Override
    public void update(String event) {
        switch (event) {
            case "LightUp" -> closedShutters = true;
            case "LightDown" -> closedShutters = false;
            case "OxygenLow" -> closedWindow = true;
            case "OxygenHigh" -> closedWindow = false;
        }
    }

    @Override
    public String toString() {
        return "Roll Shutters are closed: " + closedShutters + "," +
               "Window is closed: " + closedWindow;
    }
}
