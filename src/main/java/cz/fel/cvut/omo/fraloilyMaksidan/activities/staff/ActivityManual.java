package cz.fel.cvut.omo.fraloilyMaksidan.activities.staff;

import cz.fel.cvut.omo.fraloilyMaksidan.house.floor.Floor;
import cz.fel.cvut.omo.fraloilyMaksidan.house.room.Room;
import cz.fel.cvut.omo.fraloilyMaksidan.house.House;
import java.util.Random;

public class ActivityManual {
    private final boolean isRepairable;

    public ActivityManual(boolean isRepairable) {
        this.isRepairable = isRepairable;
    }

    public boolean findOutIfRepairable() {
        return this.isRepairable;
    }
}