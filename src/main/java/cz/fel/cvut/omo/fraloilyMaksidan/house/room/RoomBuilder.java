package cz.fel.cvut.omo.fraloilyMaksidan.house.room;

import cz.fel.cvut.omo.fraloilyMaksidan.entities.LivingEntity;
import cz.fel.cvut.omo.fraloilyMaksidan.activities.Activity;
import cz.fel.cvut.omo.fraloilyMaksidan.house.MapContext;
import cz.fel.cvut.omo.fraloilyMaksidan.house.floor.Floor;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class RoomBuilder implements Builder{
    Room room = new Room();

    @Override
    public void reset() {
        //TODO: reset all
    }

    @Override
    public RoomBuilder setName(String name) {
        room.setName(name);
        return this;
    }

    @Override
    public RoomBuilder setActivity(Activity activity) {
        // MapContext.addActivity(activity);
        this.room.setActivity(activity);
        return this;
    }

    @Override
    public RoomBuilder setActivityAll(Activity... activities) {
        room.setActivityAll(activities);
        return this;
    }

    @Override
    public RoomBuilder setActivityList(List<Activity> activities) {
        room.setActivityList(activities);
        return this;
    }

    @Override
    public RoomBuilder setEntity(LivingEntity entity) {
        this.room.setEntity(entity);
        return this;
    }

    @Override
    public RoomBuilder setEntityAll(LivingEntity... entities) {
        room.setEntitiesAll(entities);
        return this;
    }

    @Override
    public RoomBuilder setFloor(Floor floor) {
        room.setFloor(floor);
        return this;
    }

    @Override
    public RoomBuilder setFloorByNum(int floorNum) {
        room.setFloorByNum(floorNum);
        return this;
    }

    @Override
    public Room getResult() {
        return room;
    }
}
