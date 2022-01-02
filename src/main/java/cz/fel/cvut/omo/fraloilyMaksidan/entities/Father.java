package cz.fel.cvut.omo.fraloilyMaksidan.entities;

import cz.fel.cvut.omo.fraloilyMaksidan.enums.ExistingActivities;
import cz.fel.cvut.omo.fraloilyMaksidan.house.MapContext;
import cz.fel.cvut.omo.fraloilyMaksidan.sensors.Subscriber;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Father extends LivingEntity implements Subscriber {
    private static final List<ExistingActivities> standardActivities = new ArrayList<ExistingActivities>(
        Arrays.asList(ExistingActivities.COFFEE_MAKER, ExistingActivities.REPAIR_KIT,
            ExistingActivities.ELECTRIC_BIKE, ExistingActivities.COUCH,
            ExistingActivities.TV)
    );

    public Father(String name) {
        super(name, standardActivities);
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
