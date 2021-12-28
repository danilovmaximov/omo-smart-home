package cz.fel.cvut.omo.fraloilyMaksidan.activities.interactions;

import cz.fel.cvut.omo.fraloilyMaksidan.entities.LivingEntity;
import cz.fel.cvut.omo.fraloilyMaksidan.activities.staff.Activity;
import cz.fel.cvut.omo.fraloilyMaksidan.enums.Durability;

public class EventActivity extends Activity {
    private LivingEntity caller;

    public EventActivity(String name, int activityLength, LivingEntity caller) {
        super(name, activityLength, Durability.UNBREAKABLE);
        this.caller = caller;
    }

    public LivingEntity getCaller() {
        return caller;
    }

}
