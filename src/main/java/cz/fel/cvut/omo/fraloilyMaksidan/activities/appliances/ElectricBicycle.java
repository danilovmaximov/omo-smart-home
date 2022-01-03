package cz.fel.cvut.omo.fraloilyMaksidan.activities.appliances;

import cz.fel.cvut.omo.fraloilyMaksidan.enums.Durability;

public class ElectricBicycle extends ApplianceActivity {
    public ElectricBicycle() {
        super("Electric bike", 8, Durability.STRONG,
            7, 0, 0,
                1, 0, 0
        );
        standardRoomName = "Garage";
    }
}
