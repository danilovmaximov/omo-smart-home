package cz.fel.cvut.omo.fraloilyMaksidan.house.room;

import cz.fel.cvut.omo.fraloilyMaksidan.Context;
import cz.fel.cvut.omo.fraloilyMaksidan.entities.LivingEntity;
import cz.fel.cvut.omo.fraloilyMaksidan.activities.Activity;

import java.util.Arrays;

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
        this.room.setActivity(activity);
        return this;
    }

    public RoomBuilder setActivityAll(Activity... activities) {
        Arrays.stream(activities)
                .forEach(activity -> this.room.setActivity(activity));
        return this;
    }

    public RoomBuilder setEntityAll(LivingEntity... entities) {
        Arrays.stream(entities)
                .forEach(entity -> this.room.setEntity(entity));
        return this;
    }

    @Override
    public RoomBuilder setEntity(LivingEntity entity) {
        this.room.setEntity(entity);
        return this;
    }

    @Override
    public Room getResult() {
        return room;
    }
}
