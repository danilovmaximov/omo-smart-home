package cz.fel.cvut.omo.fraloilyMaksidan.activities.contextmodifiers;

import cz.fel.cvut.omo.fraloilyMaksidan.activities.ConsumingActivity;
import cz.fel.cvut.omo.fraloilyMaksidan.enums.Durability;

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
        super.step();
    }
}
