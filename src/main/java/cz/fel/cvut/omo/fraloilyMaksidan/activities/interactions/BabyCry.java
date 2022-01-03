package cz.fel.cvut.omo.fraloilyMaksidan.activities.interactions;

import cz.fel.cvut.omo.fraloilyMaksidan.activities.EventActivity;
import cz.fel.cvut.omo.fraloilyMaksidan.entities.Baby;
import cz.fel.cvut.omo.fraloilyMaksidan.entities.LivingEntity;

public class BabyCry extends EventActivity {
    public BabyCry(int activityLength, LivingEntity caller) {
        super("Crying baby", activityLength, caller);
        standardRoomName = "Child's room";
    }

    @Override
    protected void finishActivity() {
        LivingEntity c = getCaller();
        if(c instanceof Baby b) {
            b.calmDown();
        }
    }
}
