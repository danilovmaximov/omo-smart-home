package cz.fel.cvut.omo.fraloilyMaksidan.house.floor;

import cz.fel.cvut.omo.fraloilyMaksidan.house.room.Room;

public interface Builder {
    void reset();
    FloorBuilder setFloorNumber(int number);
    FloorBuilder addRoom(Room room);
    Floor getResult();
}
