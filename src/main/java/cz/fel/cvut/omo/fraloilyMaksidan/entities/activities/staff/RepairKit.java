package cz.fel.cvut.omo.fraloilyMaksidan.entities.activities.staff;

import cz.fel.cvut.omo.fraloilyMaksidan.entities.enums.Durability;

public class RepairKit extends Activity {
    private int curStep = 1;
    private Activity activity;
    private ActivityManual manual;

    public RepairKit() {
        super("Fix-a-garbage", 3, Durability.UNBREAKABLE);
    }

    @Override
    protected void manageStep() {
        if (house.hasSomethingBroken() || curStep != 1) {
            switch (curStep) {
                case 1:
                    activity = house.getBrokenActivity();
                    curStep++;
                    break;
                case 2:
                    manual = this.activity.getManual();
                    curStep++;
                    break;
                case 3:
                    if (manual.findOutIfRepairable()) {
                        activity.fixUp();
                    } else {
                        activity.getNew();
                    }
                    curStep = 1;
                    break;
            }
        }
        else {
            System.out.println("Nothing to be fixed, father chills");
            isUsing.changeState();
        }
    }
}