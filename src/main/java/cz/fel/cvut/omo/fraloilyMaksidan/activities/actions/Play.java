package cz.fel.cvut.omo.fraloilyMaksidan.activities.actions;

import cz.fel.cvut.omo.fraloilyMaksidan.activities.Activity;
import cz.fel.cvut.omo.fraloilyMaksidan.enums.Durability;

public class Play extends Activity {
    public Play() {
        super("Play", 5, Durability.UNBREAKABLE);
        standardRoom = "Child's room";
    }
}
