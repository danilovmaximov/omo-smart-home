package cz.fel.cvut.omo.fraloilyMaksidan.activities.actions;

import cz.fel.cvut.omo.fraloilyMaksidan.activities.Activity;
import cz.fel.cvut.omo.fraloilyMaksidan.enums.Durability;

public class Play extends Activity {
    public Play( int activityLength) {
        super("Play", activityLength, Durability.UNBREAKABLE);
    }
}
