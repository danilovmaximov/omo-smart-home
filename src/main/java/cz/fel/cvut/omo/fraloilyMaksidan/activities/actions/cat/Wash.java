package cz.fel.cvut.omo.fraloilyMaksidan.activities.actions.cat;

import cz.fel.cvut.omo.fraloilyMaksidan.activities.Activity;
import cz.fel.cvut.omo.fraloilyMaksidan.enums.Durability;

public class Wash extends Activity {
    public Wash() {
        super("Wash", 2, Durability.UNBREAKABLE);
    }
}
