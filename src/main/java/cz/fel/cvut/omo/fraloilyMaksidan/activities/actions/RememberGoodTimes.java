package cz.fel.cvut.omo.fraloilyMaksidan.activities.actions;

import cz.fel.cvut.omo.fraloilyMaksidan.activities.Activity;
import cz.fel.cvut.omo.fraloilyMaksidan.enums.Durability;

public class RememberGoodTimes extends Activity {
    public RememberGoodTimes() {
        super("Remember good times", 10, Durability.UNBREAKABLE);
        standardRoomName = "Hall of grandad's fame";
    }
}
