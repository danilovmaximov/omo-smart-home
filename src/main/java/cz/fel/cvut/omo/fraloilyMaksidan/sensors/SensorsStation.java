package cz.fel.cvut.omo.fraloilyMaksidan.sensors;

import cz.fel.cvut.omo.fraloilyMaksidan.Iterable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SensorsStation {
    private List<Iterable> sensors = new ArrayList<>();

    public SensorsStation(Iterable... sensors) {
        Collections.addAll(this.sensors, sensors);
    }


    public void step() {
        for (Iterable m : sensors) {
            m.step();
        }
    }

    @Override
    public String toString() {
        return "SensorsStation: { sensors: " + Arrays.toString(sensors.toArray()) + " },";
    }
}
