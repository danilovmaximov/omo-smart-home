package cz.fel.cvut.omo.fraloilyMaksidan.activities.appliances;

import cz.fel.cvut.omo.fraloilyMaksidan.enums.Durability;

public class Treadmill extends ApplianceActivity {
    public Treadmill() {
        super("Treadmill", 10, Durability.NORMAL,
                15, 0, 2,
                0, 0, 0);
    }
}
