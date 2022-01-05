package cz.fel.cvut.omo.fraloilyMaksidan.activities.contextmodifiers;

import cz.fel.cvut.omo.fraloilyMaksidan.Context;
import cz.fel.cvut.omo.fraloilyMaksidan.enums.Durability;

public class Boiler extends ContextModifierActivity {

    public Boiler() {
        super("Boiler", 2, Durability.STRONG,
            5, 10, 30, 2, 0, 0);
        standardRoomName = "Garage";
    }

    @Override
    public void step() {
        super.step();
        if (isActive()) {
            Context.changeTempLevel(3);
            System.out.println("Boiler is active");
        }
    }
}
