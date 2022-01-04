package cz.fel.cvut.omo.fraloilyMaksidan.house.floor;

import cz.fel.cvut.omo.fraloilyMaksidan.house.MapContext;
import cz.fel.cvut.omo.fraloilyMaksidan.house.room.Room;

import java.util.List;

public class FloorBuilder implements Builder {
    final Floor floor = new Floor();

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
