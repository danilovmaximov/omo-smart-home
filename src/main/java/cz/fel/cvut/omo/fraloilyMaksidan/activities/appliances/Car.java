package cz.fel.cvut.omo.fraloilyMaksidan.activities.appliances;

import cz.fel.cvut.omo.fraloilyMaksidan.enums.Durability;

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
