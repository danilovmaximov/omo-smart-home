package cz.fel.cvut.omo.fraloilyMaksidan.activities.staff;

import cz.fel.cvut.omo.fraloilyMaksidan.activities.Activity;
import cz.fel.cvut.omo.fraloilyMaksidan.enums.Durability;

public class Couch extends Activity {
    public Couch() {
        super("Couch", 2, Durability.NORMAL);
        standardRoom = "Living room";
    }
}
