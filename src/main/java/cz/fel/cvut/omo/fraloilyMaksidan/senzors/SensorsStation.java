package cz.fel.cvut.omo.fraloilyMaksidan.senzors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SensorsStation {
    private List<EventManager> sensors = new ArrayList<>();

    public SensorsStation(EventManager... sensors) {
        Collections.addAll(this.sensors, sensors);
    }

    public void step() {
        for(EventManager m : sensors) {
            m.step();
        }
    }
}
