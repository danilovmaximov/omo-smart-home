package cz.fel.cvut.omo.fraloilyMaksidan.activities;

import cz.fel.cvut.omo.fraloilyMaksidan.entities.LivingEntity;
import cz.fel.cvut.omo.fraloilyMaksidan.enums.Durability;

/**
 * Allows interaction between two entities.
 * Caller is passed to the EventActivity object, then EventActivity
 * is obtained subscriber, then it is added to a subscribers' task queue.
 */
public abstract class EventActivity extends Activity {
    private final LivingEntity caller;

    public EventActivity(String name, int activityLength, LivingEntity caller) {
        super(name, activityLength, Durability.UNBREAKABLE);
        this.caller = caller;
    }

    public LivingEntity getCaller() {
        return caller;
    }

}
