package cz.fel.cvut.omo.fraloilyMaksidan.entities.activities.staff;

import cz.fel.cvut.omo.fraloilyMaksidan.entities.enums.Durability;

public class Sleep extends Activity {
    public Sleep(int activityLength) {
        super("Sleep", activityLength, Durability.UNBREAKABLE);
    }
}
