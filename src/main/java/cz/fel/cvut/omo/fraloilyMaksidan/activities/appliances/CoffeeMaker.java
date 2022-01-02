package cz.fel.cvut.omo.fraloilyMaksidan.activities.appliances;

import cz.fel.cvut.omo.fraloilyMaksidan.enums.Durability;

public class CoffeeMaker extends ApplianceActivity {

    public CoffeeMaker() {
        super("CoffeeMaker3000",
                2,
                Durability.NORMAL,
                3, 0 , 2,
                1, 0, 0
        );
        standardRoom = "Kitchen";
    }
}
