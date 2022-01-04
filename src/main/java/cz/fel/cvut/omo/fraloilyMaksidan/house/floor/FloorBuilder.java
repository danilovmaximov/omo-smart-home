package cz.fel.cvut.omo.fraloilyMaksidan.house.floor;

import cz.fel.cvut.omo.fraloilyMaksidan.house.MapContext;
import cz.fel.cvut.omo.fraloilyMaksidan.house.room.Room;

import java.util.Arrays;
import java.util.List;

public class FloorBuilder implements Builder {
    Floor floor = new Floor();

    @Override
    public void reset() {
        //TODO: Add reset
    }

    @Override
    public FloorBuilder setFloorNumber(int number) {
        this.floor.setFloorNumber(number);
        return this;
    }

    @Override
    public FloorBuilder addRoom(Room room) {
        this.floor.addRoom(room);
        return this;
    }

    @Override
    public FloorBuilder addRoomAll(Room... rooms) {
        floor.addRoomAll(rooms);
        return this;
    }

    @Override
    public FloorBuilder addRoomList(List<Room> rooms) {
        floor.addRoomList(rooms);
        return this;
    }

    @Override
    public FloorBuilder initRooms() {
        this.floor.initRooms();
        return this;
    }

    @Override
    public FloorBuilder setToHouse() {
        MapContext.getHouse().addFloor(this.floor);
        return this;
    }

    @Override
    public Floor getResult() {
        return floor;
    }
}
