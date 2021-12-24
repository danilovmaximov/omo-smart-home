package cz.fel.cvut.omo.fraloilyMaksidan.house.floor;

import cz.fel.cvut.omo.fraloilyMaksidan.house.room.Room;
import cz.fel.cvut.omo.fraloilyMaksidan.house.House;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    private List<Room> rooms = new ArrayList<>();
    private int floorNumber;
    private House house;

    public void setHouse(House house) { this.house = house; }
    public House getHouse() { return this.house; }

    public void addRoom(Room room) {
        this.rooms.add(room);
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public void initRooms() {
        for (Room room : rooms) {
            room.setFloor(this);
        }
    }

    public void step() {
        for(Room r: rooms) {
            r.step();
        }
    }
}
