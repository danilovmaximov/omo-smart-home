package cz.fel.cvut.omo.fraloilyMaksidan.entities.activities;

import cz.fel.cvut.omo.fraloilyMaksidan.entities.LivingEntity;
import cz.fel.cvut.omo.fraloilyMaksidan.house.House;

public class RepairKit extends Activity {
    public RepairKit() {
        super("Fix-a-garbage", 1, Durability.UNBREAKABLE);
    }

    @Override
    public void doActivity(LivingEntity entity) {
        if (house.hasSomethingBroken()) {
            Activity activity = house.getBrokenActivity();
            activity.fixUp();
            System.out.println(entity + " fixed up " + activity);
        }
        else {
            System.out.println("Nothing to be fixed, father chills");
            entity.changeState();
        }
    }
}
