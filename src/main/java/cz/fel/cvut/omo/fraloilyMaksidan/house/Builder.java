package cz.fel.cvut.omo.fraloilyMaksidan.house;

import cz.fel.cvut.omo.fraloilyMaksidan.house.floor.Floor;
import cz.fel.cvut.omo.fraloilyMaksidan.senzors.SunSensor;

public interface Builder {
    void reset();

    HouseBuilder setAddress(String address);
    HouseBuilder addFloor(Floor floor);
    HouseBuilder initFloors();
    HouseBuilder addSensor(SunSensor sensor);
    House getResult();
}
