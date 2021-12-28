package cz.fel.cvut.omo.fraloilyMaksidan.activities.interactions;

import cz.fel.cvut.omo.fraloilyMaksidan.entities.Baby;
import cz.fel.cvut.omo.fraloilyMaksidan.entities.LivingEntity;

public class BabyCry extends EventActivity {
    public BabyCry(int activityLength, LivingEntity caller) {
        super("Crying", activityLength, caller);
    }

    @Override
    protected void finishActivity() {
        LivingEntity c = getCaller();
        if(c instanceof Baby) {
            System.out.println("Baby status changed!");
            Baby b = (Baby) c;
            b.calmDown();
        }
    }
}
