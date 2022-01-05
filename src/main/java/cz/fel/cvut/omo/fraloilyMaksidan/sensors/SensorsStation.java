package cz.fel.cvut.omo.fraloilyMaksidan.sensors;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Contains all house sensors.
 */
public class SensorsStation {
    private final List<Sensor> sensors = new ArrayList<>();

    public SensorsStation(Sensor... sensors) {
        Collections.addAll(this.sensors, sensors);
    }

    public void addSensors(Sensor... sensors) {
        Collections.addAll(this.sensors, sensors);
    }

    public List<Sensor> getSensors() {
        return this.sensors;
    }

    public void step() {
        for (Sensor m : sensors) {
            m.step();
        }
    }

    @Override
    public String toString() {
        return "SensorsStation: { sensors: " + Arrays.toString(sensors.toArray()) + " },";
    }
}
