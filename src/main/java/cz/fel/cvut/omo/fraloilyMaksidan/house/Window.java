package cz.fel.cvut.omo.fraloilyMaksidan.house;

import cz.fel.cvut.omo.fraloilyMaksidan.Context;
import cz.fel.cvut.omo.fraloilyMaksidan.sensors.EventManager;
import cz.fel.cvut.omo.fraloilyMaksidan.sensors.Subscriber;

public class Window implements Subscriber {
    private Context context = Context.getInstance();
    boolean closedCurtain = false;

    @Override
    public void update(String event) {
        switch (event) {
            case "LightUp" -> closedCurtain = true;
            case "LightDown" -> closedCurtain = false;
        }
    }

    @Override
    public String toString() {
        return "Window: isClosed " + closedCurtain;
    }
}
