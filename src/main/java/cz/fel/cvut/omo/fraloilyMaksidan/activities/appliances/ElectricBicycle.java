package cz.fel.cvut.omo.fraloilyMaksidan.activities.appliances;

import cz.fel.cvut.omo.fraloilyMaksidan.enums.Durability;

public class ElectricBicycle extends ApplianceActivity {
    public ElectricBicycle(int activityLength) {
        super("Electric bike", activityLength, Durability.STRONG,
            7, 0, 0,
                1, 0, 0
        );
    }
}
