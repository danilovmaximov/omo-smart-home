package cz.fel.cvut.omo.fraloilyMaksidan.house.room;

import cz.fel.cvut.omo.fraloilyMaksidan.entities.LivingEntity;
import cz.fel.cvut.omo.fraloilyMaksidan.entities.activities.Activity;

public interface Builder {
    void reset();
    RoomBuilder setActivityObjects(Activity activity);
    RoomBuilder setEntities(LivingEntity entity);
    Room getResult();
}
