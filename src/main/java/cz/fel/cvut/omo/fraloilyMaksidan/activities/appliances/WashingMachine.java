package cz.fel.cvut.omo.fraloilyMaksidan.activities.appliances;

import cz.fel.cvut.omo.fraloilyMaksidan.enums.Durability;

public class WashingMachine extends ApplianceActivity {
    public WashingMachine() {
        super("Washing machine", 7, Durability.NORMAL,
                20, 0, 20,
                1, 0, 2);
    }
}
