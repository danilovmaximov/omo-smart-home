package cz.fel.cvut.omo.fraloilyMaksidan.house.floor;

import cz.fel.cvut.omo.fraloilyMaksidan.house.room.Room;

public interface Builder {
    void reset();

    FloorBuilder setFloorNumber(int number);
    FloorBuilder addRoom(Room room);
    FloorBuilder addRoomAll(Room... room);
    FloorBuilder initRooms();
    Floor getResult();
}
