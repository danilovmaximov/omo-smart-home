package cz.fel.cvut.omo.fraloilyMaksidan.entities.activities.staff;

import cz.fel.cvut.omo.fraloilyMaksidan.entities.enums.Durability;

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
        if (house.hasSomethingBroken() || curStep != 1) {
            switch (curStep) {
                case 1:  // get the activity
                    activity = house.getBrokenActivity();
                    curFloor = 0;
                    curRoom = 0;
                    curStep++;
                    break;
                case 2:  // check every room for manual
                    if (house.getFloor(curFloor).getRoom(curRoom) == manual.getRoom()) curStep++;
                    else {
                        if (curRoom + 1 == house.getFloor(curFloor).getRoomsNum()) {
                            if (curFloor + 1 == house.getFloorsNum())
                                throw new RuntimeException("Entity failed to find manual!");
                            curRoom = 0;
                            curFloor++;
                        } else curRoom++;
                        this.isUsing.setRoom(house.getFloor(curFloor).getRoom(curRoom));
                    }
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