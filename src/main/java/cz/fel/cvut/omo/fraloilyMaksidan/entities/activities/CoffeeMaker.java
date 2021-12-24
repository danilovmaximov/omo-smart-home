package cz.fel.cvut.omo.fraloilyMaksidan.entities.activities;

import cz.fel.cvut.omo.fraloilyMaksidan.house.room.Room;
import cz.fel.cvut.omo.fraloilyMaksidan.reports.ActivityReporter;

public class CoffeeMaker extends Activity {

    public static final int MAX_LENGTH = 2;

    public CoffeeMaker() {
        super("CoffeeMaker3000", 2, Durability.NORMAL);
    }
}
