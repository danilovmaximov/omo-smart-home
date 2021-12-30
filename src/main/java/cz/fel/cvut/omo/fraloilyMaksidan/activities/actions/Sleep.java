package cz.fel.cvut.omo.fraloilyMaksidan.activities.actions;

import cz.fel.cvut.omo.fraloilyMaksidan.activities.Activity;
import cz.fel.cvut.omo.fraloilyMaksidan.enums.Durability;

public class Sleep extends Activity {
    public Sleep(int activityLength) {
        super("Sleep", activityLength, Durability.UNBREAKABLE);
    }
}
