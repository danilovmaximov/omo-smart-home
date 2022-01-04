package cz.fel.cvut.omo.fraloilyMaksidan.house.room;

import cz.fel.cvut.omo.fraloilyMaksidan.entities.LivingEntity;
import cz.fel.cvut.omo.fraloilyMaksidan.activities.Activity;
import cz.fel.cvut.omo.fraloilyMaksidan.house.floor.Floor;

import java.util.List;

public interface Builder {
    RoomBuilder setName(String name);
    RoomBuilder setFloor(Floor floor);
    RoomBuilder setFloorByNum(int floorNum);
    RoomBuilder setActivity(Activity activity);
    RoomBuilder setActivityAll(Activity... activities);
    RoomBuilder setActivityList(List<Activity> activities);
    RoomBuilder setEntity(LivingEntity entity);
    RoomBuilder setEntityAll(LivingEntity... entities);
    Room getResult();
}
