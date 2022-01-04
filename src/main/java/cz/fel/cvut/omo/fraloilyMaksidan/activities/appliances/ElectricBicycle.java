package cz.fel.cvut.omo.fraloilyMaksidan.activities.appliances;

import cz.fel.cvut.omo.fraloilyMaksidan.Configurator;
import cz.fel.cvut.omo.fraloilyMaksidan.enums.Durability;
import cz.fel.cvut.omo.fraloilyMaksidan.enums.ExistingActivities;

public class ElectricBicycle extends ApplianceActivity {
    public ElectricBicycle() {
        super("Electric bike", 8, Durability.STRONG,
            20, 0, 0,
                1, 0, 0
        );
        standardRoomName = "Garage";
    }

    @Override
    protected void manageStep() {
        if (currentStep == 1) {
            isUsing.setAway(true);
        }
        super.manageStep();
    }

    @Override
    protected void finishActivity() {
        isUsing.setAway(false);
        super.finishActivity();
    }
}
