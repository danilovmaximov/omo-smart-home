package cz.fel.cvut.omo.fraloilyMaksidan.activities.staff;

import cz.fel.cvut.omo.fraloilyMaksidan.activities.Activity;
import cz.fel.cvut.omo.fraloilyMaksidan.enums.Durability;

public class Couch extends Activity {
    public Couch(int activityLength) {
        super("Couch", activityLength, Durability.NORMAL);
    }
}
