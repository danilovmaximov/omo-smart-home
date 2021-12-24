package cz.fel.cvut.omo.fraloilyMaksidan.house.floor;

import cz.fel.cvut.omo.fraloilyMaksidan.house.room.Room;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    private List<Room> rooms = new ArrayList<>();
    private int floorNumber;

    public void AddRoom(Room room) {
        this.rooms.add(room);
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public void step() {
        for(Room r: rooms) {
            r.step();
        }
    }
}
