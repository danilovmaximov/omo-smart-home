package cz.fel.cvut.omo.fraloilyMaksidan.senzors;

public class SunSensor extends EventManager {
    @Override
    public void step() {
        int lightLevel = context.getLightLevel();
        //TODO: Add logic here;
        if(lightLevel > 90) {
            this.notifySubscribers();
        }
    }
}
