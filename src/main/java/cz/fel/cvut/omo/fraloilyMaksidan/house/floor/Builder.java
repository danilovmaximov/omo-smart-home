package cz.fel.cvut.omo.fraloilyMaksidan.house.floor;

import cz.fel.cvut.omo.fraloilyMaksidan.house.room.Room;

import java.util.List;

public interface Builder {
    void reset();

    FloorBuilder setFloorNumber(int number);
    FloorBuilder addRoom(Room room);
    FloorBuilder addRoomAll(Room... rooms);
    FloorBuilder addRoomList(List<Room> rooms);
    FloorBuilder initRooms();
    FloorBuilder setToHouse();
    Floor getResult();
}
