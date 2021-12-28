package cz.fel.cvut.omo.fraloilyMaksidan.house.room;

import cz.fel.cvut.omo.fraloilyMaksidan.Context;
import cz.fel.cvut.omo.fraloilyMaksidan.entities.LivingEntity;
import cz.fel.cvut.omo.fraloilyMaksidan.activities.staff.Activity;

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

    @Override
    public RoomBuilder setEntity(LivingEntity entity) {
        Context.addEntity(entity);
        this.room.setEntity(entity);
        return this;
    }

    @Override
    public Room getResult() {
        return room;
    }
}
