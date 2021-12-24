package cz.fel.cvut.omo.fraloilyMaksidan.entities.activities;

import cz.fel.cvut.omo.fraloilyMaksidan.entities.LivingEntity;
import cz.fel.cvut.omo.fraloilyMaksidan.house.Room;
import cz.fel.cvut.omo.fraloilyMaksidan.reports.ActivityReporter;

public class CoffeeMaker extends Activity {

    public static final int MAX_LENGTH = 2;

    public CoffeeMaker(Room room, ActivityReporter reporter) {
        super(room, "CoffeeMaker3000", 2, reporter);
    }
}
