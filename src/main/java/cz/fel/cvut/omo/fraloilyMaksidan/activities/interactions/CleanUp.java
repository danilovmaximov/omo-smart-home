package cz.fel.cvut.omo.fraloilyMaksidan.activities.interactions;

import cz.fel.cvut.omo.fraloilyMaksidan.activities.EventActivity;
import cz.fel.cvut.omo.fraloilyMaksidan.entities.Cat;
import cz.fel.cvut.omo.fraloilyMaksidan.entities.LivingEntity;

public class CleanUp extends EventActivity {
    public CleanUp(LivingEntity caller) {
        super("Clean up", 4, caller);
    }

    @Override
    protected void finishActivity() {
        LivingEntity caller = getCaller();
        if (caller instanceof Cat) {
            ((Cat) caller).cleanedUp();
        }
    }
}
