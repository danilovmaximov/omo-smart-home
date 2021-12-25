package cz.fel.cvut.omo.fraloilyMaksidan.entities.activities.appliances;

import cz.fel.cvut.omo.fraloilyMaksidan.entities.activities.appliances.consumptions.ElectricityConsumption;
import cz.fel.cvut.omo.fraloilyMaksidan.entities.activities.appliances.consumptions.WaterConsumption;
import cz.fel.cvut.omo.fraloilyMaksidan.entities.enums.Durability;

public class CoffeeMaker extends ApplianceActivity {

    public CoffeeMaker() {
        super("CoffeeMaker3000",
                2,
                Durability.NORMAL,
                new ElectricityConsumption(2),
                new WaterConsumption(1)
        );
    }
}
