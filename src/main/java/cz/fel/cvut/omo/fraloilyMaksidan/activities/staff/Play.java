package cz.fel.cvut.omo.fraloilyMaksidan.activities.staff;

import cz.fel.cvut.omo.fraloilyMaksidan.entities.enums.Durability;

public class Play extends Activity {
    public Play( int activityLength) {
        super("Sleep", activityLength, Durability.UNBREAKABLE);
    }
}
