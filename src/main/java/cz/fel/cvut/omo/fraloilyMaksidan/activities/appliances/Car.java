package cz.fel.cvut.omo.fraloilyMaksidan.activities.appliances;

import cz.fel.cvut.omo.fraloilyMaksidan.Configurator;
import cz.fel.cvut.omo.fraloilyMaksidan.enums.Durability;
import cz.fel.cvut.omo.fraloilyMaksidan.enums.ExistingActivities;
import cz.fel.cvut.omo.fraloilyMaksidan.house.MapContext;
import cz.fel.cvut.omo.fraloilyMaksidan.house.room.Room;

public class Car extends ApplianceActivity {
    public Car() {
        super("Car", 20, Durability.STRONG,
                0, 30, 0,
                0, 0, 0);
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
