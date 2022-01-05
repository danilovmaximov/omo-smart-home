package cz.fel.cvut.omo.fraloilyMaksidan.house;
import cz.fel.cvut.omo.fraloilyMaksidan.sensors.observer.Subscriber;

public class Window implements Subscriber {
    private boolean closedShutters = false;
    private boolean closedWindow = false;

    private final int closedOxygenChange = 0;
    private final int openedOxygenChange = 3;

    public int getOxygenChange() {
        return closedWindow ? closedOxygenChange : openedOxygenChange;
    }

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
        return "Window";
    }
}
