package cz.fel.cvut.omo.fraloilyMaksidan.entities.activities.staff;

import cz.fel.cvut.omo.fraloilyMaksidan.house.floor.Floor;
import cz.fel.cvut.omo.fraloilyMaksidan.house.room.Room;
import cz.fel.cvut.omo.fraloilyMaksidan.house.House;
import java.util.Random;

public class ActivityManual {
    private final boolean isRepairable;
    private final Room room;

    public ActivityManual(House house, boolean isRepairable) {
        this.isRepairable = isRepairable;

        Floor floor;
        Random rand = new Random();
        floor = house.getFloor(rand.nextInt(0, house.getFloorsNum()));
        this.room = floor.getRoom(rand.nextInt(0, floor.getRoomsNum()));
    }

    public Room getRoom() { return this.room; }
    public boolean findOutIfRepairable() {
        return this.isRepairable;
    }
}