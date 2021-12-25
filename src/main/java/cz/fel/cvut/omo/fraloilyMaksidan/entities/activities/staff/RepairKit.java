package cz.fel.cvut.omo.fraloilyMaksidan.entities.activities.staff;

import cz.fel.cvut.omo.fraloilyMaksidan.entities.LivingEntity;
import cz.fel.cvut.omo.fraloilyMaksidan.entities.activities.staff.Activity;
import cz.fel.cvut.omo.fraloilyMaksidan.entities.enums.Durability;

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
