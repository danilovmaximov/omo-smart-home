package cz.fel.cvut.omo.fraloilyMaksidan.house.room;

import cz.fel.cvut.omo.fraloilyMaksidan.entities.LivingEntity;
import cz.fel.cvut.omo.fraloilyMaksidan.activities.Activity;
import cz.fel.cvut.omo.fraloilyMaksidan.house.MapContext;

import java.util.Arrays;
import java.util.List;

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

    public RoomBuilder setActivityAll(Activity... activities) {
        Arrays.stream(activities)
                .forEach(this::setActivity);
        return this;
    }

    public RoomBuilder setActivityList(List<Activity> activities) {
        activities.stream()
            .forEach(this::setActivity);
        return this;
    }

    @Override
    public RoomBuilder setEntity(LivingEntity entity) {
        // MapContext.addEntity(entity);
        this.room.setEntity(entity);
        return this;
    }

    public RoomBuilder setEntityAll(LivingEntity... entities) {
        Arrays.stream(entities)
                .forEach(this::setEntity);
        return this;
    }

    @Override
    public Room getResult() {
        return room;
    }
}
