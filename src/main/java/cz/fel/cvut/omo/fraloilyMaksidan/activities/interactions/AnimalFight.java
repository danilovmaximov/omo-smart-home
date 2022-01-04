package cz.fel.cvut.omo.fraloilyMaksidan.activities.interactions;

import cz.fel.cvut.omo.fraloilyMaksidan.activities.EventActivity;
import cz.fel.cvut.omo.fraloilyMaksidan.entities.Dog;
import cz.fel.cvut.omo.fraloilyMaksidan.entities.LivingEntity;

public class AnimalFight extends EventActivity {

    public AnimalFight(LivingEntity caller) {
        super("Animal fight", 5, caller);
    }

    @Override
    protected void finishActivity() {
        LivingEntity caller = getCaller();
        if (caller instanceof Dog) {
            ((Dog) caller).stopFighting();
        }
    }
}
