package cz.fel.cvut.omo.fraloilyMaksidan.activities.actions;

import cz.fel.cvut.omo.fraloilyMaksidan.activities.Activity;
import cz.fel.cvut.omo.fraloilyMaksidan.enums.Durability;

public class RememberGoodTimes extends Activity {
    public RememberGoodTimes(int activityLength) {
        super("Remember old times...", activityLength,Durability.UNBREAKABLE);
    }
}
