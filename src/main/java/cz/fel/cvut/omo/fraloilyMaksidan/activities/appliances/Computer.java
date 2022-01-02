package cz.fel.cvut.omo.fraloilyMaksidan.activities.appliances;

import cz.fel.cvut.omo.fraloilyMaksidan.enums.Durability;

public class Computer extends ApplianceActivity {
    public Computer() {
        super("Computer", 5, Durability.NORMAL,
            15, 0, 0,
                4, 0, 0
        );
        standardRoom = "Office";
    }
}
