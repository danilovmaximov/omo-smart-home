package cz.fel.cvut.omo.fraloilyMaksidan.activities.appliances;

import cz.fel.cvut.omo.fraloilyMaksidan.activities.ApplianceActivity;
import cz.fel.cvut.omo.fraloilyMaksidan.enums.Durability;
import cz.fel.cvut.omo.fraloilyMaksidan.sensors.Subscriber;

public class Boiler extends ApplianceActivity implements Subscriber {
    public Boiler(String name, int activityLength, Durability durability,
                  int electricityActive, int gasActive, int waterActive,
                  int electricityIdle, int gasIdle, int waterIdle) {
        super(name, activityLength, durability,
                electricityActive, gasActive, waterActive,
                electricityIdle, gasIdle, waterIdle);
    }

    @Override
    public void update(String event) {
        switch (event) {
            // case "ItsCold" -> this.addEmergentActivity();
            // case "ItsWarm" -> this.addEmergentActivity();
        }
    }
}
