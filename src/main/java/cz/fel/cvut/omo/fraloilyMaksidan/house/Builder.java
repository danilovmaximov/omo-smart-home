package cz.fel.cvut.omo.fraloilyMaksidan.house;

import cz.fel.cvut.omo.fraloilyMaksidan.house.floor.Floor;
import cz.fel.cvut.omo.fraloilyMaksidan.sensors.Sensor;

public interface Builder {
    void reset();

    HouseBuilder setAddress(String address);
    HouseBuilder addFloor(Floor floor);
    HouseBuilder addFloorAll(Floor... floors);
    HouseBuilder initFloors();
    HouseBuilder addSensors(Sensor... sensor);
    House getResult();
}
