package cz.fel.cvut.omo.fraloilyMaksidan.activities.appliances;

import cz.fel.cvut.omo.fraloilyMaksidan.activities.ApplianceActivity;
import cz.fel.cvut.omo.fraloilyMaksidan.enums.Durability;

import java.util.List;

public class CoffeeMaker extends ApplianceActivity {

    public CoffeeMaker() {
        super("CoffeeMaker3000",
                2,
                Durability.NORMAL,
                3, 0 , 2,
                1, 0, 0
        );
    }
}
