package cz.fel.cvut.omo.fraloilyMaksidan.activities.appliances;

import cz.fel.cvut.omo.fraloilyMaksidan.activities.ApplianceActivity;
import cz.fel.cvut.omo.fraloilyMaksidan.enums.Durability;

import java.util.List;

public class TV extends ApplianceActivity {
    public TV(int activityLength) {
        super("TV", activityLength, Durability.WEAK,
            15, 0 ,0,
                5, 0 ,0
        );
    }
}
