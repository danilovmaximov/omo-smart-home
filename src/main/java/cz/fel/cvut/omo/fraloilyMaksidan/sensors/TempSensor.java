package cz.fel.cvut.omo.fraloilyMaksidan.sensors;

public class TempSensor extends Sensor {
    String name = "Temperature sensor";
    boolean reportedUp = false;

    public TempSensor(String... operations) {
        super(operations);
    }

    @Override
    public void step() {

    }
}
