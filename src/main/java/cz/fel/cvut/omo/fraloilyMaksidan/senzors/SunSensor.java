package cz.fel.cvut.omo.fraloilyMaksidan.senzors;

public class SunSensor extends EventManager {

    boolean reportedUp;
    public SunSensor(String... operations) {
        super(operations);
    }

    @Override
    public void step() {
        int lightLevel = context.getLightLevel();
        //TODO: Add logic here;
        if(lightLevel > 90 && !reportedUp) {
            reportedUp = true;
            this.notifySubscribers("LightUp");
        }

        if(lightLevel < 90 & reportedUp) {
            reportedUp = false;
            this.notifySubscribers("LightDown");
        }
    }
}
