package cz.fel.cvut.omo.fraloilyMaksidan.activities.staff;

import cz.fel.cvut.omo.fraloilyMaksidan.activities.Activity;
import cz.fel.cvut.omo.fraloilyMaksidan.enums.Durability;
import cz.fel.cvut.omo.fraloilyMaksidan.Context;

public class RepairKit extends Activity {
    private int curStep = 1;
    private Activity activity;
    private ActivityManual manual;

    public RepairKit() {
        super("Fix-a-garbage", 4, Durability.UNBREAKABLE);
    }

    int curFloor, curRoom;
    @Override
    protected void manageStep() {
        if (Context.hasSomethingBroken() || curStep != 1) {
            switch (curStep) {
                case 1:  // get the activity
                    activity = Context.getBrokenActivity();
                    curFloor = 0;
                    curRoom = 0;
                    curStep++;
                    break;
                case 2:  // find manual


                    break;
                case 3:  // get the manual
                    manual = this.activity.getManual();
                    curStep++;
                    break;
                case 4:  // repair or buy new activity
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
            isUsing.nextActivity();
        }
    }
}