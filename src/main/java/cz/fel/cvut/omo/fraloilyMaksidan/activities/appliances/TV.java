package cz.fel.cvut.omo.fraloilyMaksidan.activities.appliances;

import cz.fel.cvut.omo.fraloilyMaksidan.enums.Durability;

public class TV extends ApplianceActivity {
    public TV() {
        super("TV", 3, Durability.WEAK,
            15, 0 ,0,
                5, 0 ,0
        );
        standardRoomName = "Living room";
    }
}
