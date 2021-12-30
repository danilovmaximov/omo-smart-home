package cz.fel.cvut.omo.fraloilyMaksidan.activities.appliances;

import cz.fel.cvut.omo.fraloilyMaksidan.activities.ApplianceActivity;
import cz.fel.cvut.omo.fraloilyMaksidan.enums.Durability;

import java.util.List;

public class Computer extends ApplianceActivity {
    public Computer(int activityLength) {
        super("Computer", activityLength, Durability.NORMAL,
            15, 0, 0,
                4, 0, 0
        );
    }
}
