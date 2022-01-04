package cz.fel.cvut.omo.fraloilyMaksidan.activities.appliances;

import cz.fel.cvut.omo.fraloilyMaksidan.enums.Durability;

public class KitchenStove extends ApplianceActivity {
    public KitchenStove() {
        super("Kitchen stove", 6, Durability.STRONG,
                30, 0, 4,
                2, 0, 0);
        standardRoomName = "Kitchen";
    }
}
