package cz.fel.cvut.omo.fraloilyMaksidan.activities.actions;

import cz.fel.cvut.omo.fraloilyMaksidan.activities.Activity;
import cz.fel.cvut.omo.fraloilyMaksidan.enums.Durability;

public class Walk extends Activity {
    public Walk() {
        super("Walk", 30, Durability.UNBREAKABLE);
    }
}
