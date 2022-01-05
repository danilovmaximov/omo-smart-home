package cz.fel.cvut.omo.fraloilyMaksidan.activities.staff;

import cz.fel.cvut.omo.fraloilyMaksidan.activities.Activity;
import cz.fel.cvut.omo.fraloilyMaksidan.enums.Durability;
import cz.fel.cvut.omo.fraloilyMaksidan.Context;

public class RepairKit extends Activity {
    private int curStep = 1;
    private int manualSearchStep = 1;
    private Activity activity;
    private ActivityManual manual;

    public RepairKit() {
        super("Repair kit", 3, Durability.UNBREAKABLE);
        standardRoomName = "Garage";
    }

    @Override
    protected void manageStep() {
        if (Context.hasSomethingBroken() || curStep != 1) {
          switch (curStep) {
            case 1 -> {  // get the activity
                activity = Context.getBrokenActivity();
                curStep++;
            }
            case 2 -> {  // find manual
                System.out.println("Looking for manual...");
                if (manualSearchStep < 5) {
                    manualSearchStep += 1;
                } else {
                    manualSearchStep = 1;
                    manual = this.activity.getManual();
                    curStep++;
                }
            }
            case 3 -> {  // repair or buy new activity
                if (manual.findOutIfRepairable()) {
                    activity.fixUp();
                } else {
                    activity.getNew();
                }
                curStep = 1;
                finishActivity();
            }
          }
        }
        else {
            System.out.println("Nothing to be fixed, father chills");
            isUsing.nextActivity();
        }
    }
}