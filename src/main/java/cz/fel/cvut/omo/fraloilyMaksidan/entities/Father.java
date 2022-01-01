package cz.fel.cvut.omo.fraloilyMaksidan.entities;

import cz.fel.cvut.omo.fraloilyMaksidan.activities.Activity;
import cz.fel.cvut.omo.fraloilyMaksidan.house.Boiler;
import cz.fel.cvut.omo.fraloilyMaksidan.house.MapContext;
import cz.fel.cvut.omo.fraloilyMaksidan.sensors.Subscriber;

public class Father extends LivingEntity implements Subscriber {
    public Father(String name, Activity... activities) {
        super(name, activities);
    }

    @Override
    public void update(String event) {
        switch (event) {
            case "ItsCold" -> {
                System.out.println(name + ": \"Winter is coming\"");
                goToTempRaiser(false);
            }
            case "ItsWarm" -> {
                System.out.println(name + ": \"Winter is over\"");
                goToTempRaiser(true);
            }
        }
    }

    private void goToTempRaiser(boolean active) {
        var raiser = MapContext.getTemperatureRaisers(active);
        System.out.println(raiser);
        if (raiser != null) {
            this.addEmergentActivity(raiser);
        }
    }
}
