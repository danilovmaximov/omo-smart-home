package cz.fel.cvut.omo.fraloilyMaksidan.house.floor;

import cz.fel.cvut.omo.fraloilyMaksidan.house.room.Room;
import cz.fel.cvut.omo.fraloilyMaksidan.house.House;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Floor {
    private final  List<Room> rooms = new ArrayList<>();
    private int floorNumber;
    private House house;

    public void setHouse(House house) {
        this.house = house;
    }
    public House getHouse() { return this.house; }

    public void removeRoom(Room room) {
        this.rooms.remove(room);
    }

    public void addRoom(Room room) {
        this.rooms.add(room);
    }

    public void addRoomAll(Room... rooms) {
        Arrays.stream(rooms)
                .forEach(this::addRoom);
    }

    public void addRoomList(List<Room> rooms) {
        rooms
                .forEach(this::addRoom);
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public int getFloorNumber() {
        return this.floorNumber;
    }

    public Room getRoom(int i) { return this.rooms.get(i); }
    public int getRoomsNum() { return this.rooms.size(); }

    public List<Room> getRooms() {
        return rooms;
    }

    public void initRooms() {
        for (Room room : rooms) {
            room.setFloor(this);
        }
    }

    @Override
    public String toString() {
        return "{ " +
                "name: floor, "+
                "number: " + floorNumber + ", " +
                "rooms: "  + Arrays.toString(rooms.toArray()) + ", " +
                "entitiesOnTheFloor: " + rooms.stream().map(Room::entitiesConfiguration).collect(Collectors.joining()) +
                " }";
    }
}
