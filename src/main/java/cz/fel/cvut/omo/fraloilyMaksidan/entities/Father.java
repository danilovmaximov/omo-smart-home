package cz.fel.cvut.omo.fraloilyMaksidan.entities;

import cz.fel.cvut.omo.fraloilyMaksidan.activities.Activity;
import cz.fel.cvut.omo.fraloilyMaksidan.enums.ExistingActivities;
import cz.fel.cvut.omo.fraloilyMaksidan.house.MapContext;
import cz.fel.cvut.omo.fraloilyMaksidan.sensors.observer.Subscriber;

import java.util.List;

public class Father extends LivingEntity implements Subscriber {

    public Father(String name, List<Activity> activities) {
        super(name, activities);
    }

    @Override
    public void update(String event) {
        switch (event) {
            case "Its cold" -> {
                System.out.println(name + ": \"Winter is coming\"");
                goToTempRaiser(false);
            }
            case "Its warm" -> {
                System.out.println(name + ": \"Winter is over\"");
                goToTempRaiser(true);
            }
            case "New breakage" -> {
                System.out.println(name + ": \"I know something's broken\"");
                this.addEmergentActivity(
                        MapContext.getActivitiesInHouse().get(ExistingActivities.REPAIR_KIT.getName())
                );
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
