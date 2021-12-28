package cz.fel.cvut.omo.fraloilyMaksidan.entities.activities.interactions;

import cz.fel.cvut.omo.fraloilyMaksidan.entities.LivingEntity;

public class BabyCry extends EventActivity{
    public BabyCry(int activityLength, LivingEntity caller) {
        super("Crying", activityLength, caller);
    }
}
