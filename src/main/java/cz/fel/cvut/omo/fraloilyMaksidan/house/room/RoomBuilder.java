package cz.fel.cvut.omo.fraloilyMaksidan.house.room;

import cz.fel.cvut.omo.fraloilyMaksidan.entities.LivingEntity;
import cz.fel.cvut.omo.fraloilyMaksidan.entities.activities.staff.Activity;

public class RoomBuilder implements Builder{
    Room room = new Room();
    @Override
    public void reset() {
        //TODO: reset all
    }

    public RoomBuilder setName(String name) {
        room.setName(name);
        return this;
    }

    public RoomBuilder setActivity(Activity activity) {
        this.room.setActivity(activity);
        return this;
    }

    @Override
    public RoomBuilder setEntities(LivingEntity entity) {
        this.room.getEntities().add(entity);
        return this;
    }

    @Override
    public Room getResult() {
        return room;
    }
}
