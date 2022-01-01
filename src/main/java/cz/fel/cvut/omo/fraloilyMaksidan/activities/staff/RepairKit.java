package cz.fel.cvut.omo.fraloilyMaksidan.activities.staff;

import cz.fel.cvut.omo.fraloilyMaksidan.activities.Activity;
import cz.fel.cvut.omo.fraloilyMaksidan.enums.Durability;
import cz.fel.cvut.omo.fraloilyMaksidan.Context;

import java.beans.IntrospectionException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class RepairKit extends Activity {
    private int curStep = 1;
    private Activity activity;
    private ActivityManual manual;

    public RepairKit() {
        super("Fix-a-garbage", 3, Durability.UNBREAKABLE);
    }

    @Override
    protected void manageStep() {
        if (Context.hasSomethingBroken() || curStep != 1) {
            switch (curStep) {
                case 1:  // get the activity
                    activity = Context.getBrokenActivity();
                    curStep++;
                    break;
                case 2:  // find manual
                    try {
                        Random r = new Random();
                        System.out.println("Looking for manual...");
                        TimeUnit.SECONDS.sleep(r.nextInt(0, 5));
                    }
                    catch (InterruptedException e) {
                        System.out.println("Interruption while looking for manual");
                    }
                    manual = this.activity.getManual();
                    curStep++;
                    break;
                case 3:  // repair or buy new activity
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