package cz.fel.cvut.omo.fraloilyMaksidan.activities.contextmodifiers;

import cz.fel.cvut.omo.fraloilyMaksidan.activities.ConsumingActivity;
import cz.fel.cvut.omo.fraloilyMaksidan.enums.Durability;
import cz.fel.cvut.omo.fraloilyMaksidan.reports.reportTransactions.ConsumptionTransaction;

public abstract class ContextModifierActivity extends ConsumingActivity {

    private boolean isActive = false;

    public ContextModifierActivity(String name, int activityLength, Durability durability,
                                   int electricityActive, int gasActive, int waterActive,
                                   int electricityIdle, int gasIdle, int waterIdle) {
        super(name, activityLength, durability, electricityActive, gasActive, waterActive, electricityIdle, gasIdle, waterIdle);
    }

    public boolean isActive() {
        return isActive;
    }

    public void toggleActivity() {
        isActive = !isActive;
    }

    @Override
    public void finishActivity() {
        super.finishActivity();
        System.out.println("Boiler toggled");
        toggleActivity();
    }

    @Override
    public void step() {
        if(isActive) {
            currentTransaction = new ConsumptionTransaction(this, electricityActive,gasActive, waterActive);
        } else {
            currentTransaction = new ConsumptionTransaction(this, electricityIdle, gasIdle, waterIdle);
        }
        super.step();
    }
}
