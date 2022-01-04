package cz.fel.cvut.omo.fraloilyMaksidan.activities.actions.dog;

import cz.fel.cvut.omo.fraloilyMaksidan.activities.Activity;
import cz.fel.cvut.omo.fraloilyMaksidan.enums.Durability;

public class Bark extends Activity {
    public Bark() {
        super("Bark", 2, Durability.UNBREAKABLE);
    }
}
