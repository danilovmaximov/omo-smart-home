package cz.fel.cvut.omo.fraloilyMaksidan.activities.staff;

import cz.fel.cvut.omo.fraloilyMaksidan.Configurator;
import cz.fel.cvut.omo.fraloilyMaksidan.activities.Activity;
import cz.fel.cvut.omo.fraloilyMaksidan.enums.Durability;
import cz.fel.cvut.omo.fraloilyMaksidan.enums.ExistingActivities;

public class Skis extends Activity {
    public Skis() {
        super("Skis", 20, Durability.STRONG);
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
