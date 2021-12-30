package cz.fel.cvut.omo.fraloilyMaksidan.house.room;

import cz.fel.cvut.omo.fraloilyMaksidan.entities.LivingEntity;
import cz.fel.cvut.omo.fraloilyMaksidan.activities.Activity;

public interface Builder {
    void reset();

    RoomBuilder setName(String name);
    RoomBuilder setActivity(Activity activity);
    RoomBuilder setEntity(LivingEntity entity);
    Room getResult();
}
