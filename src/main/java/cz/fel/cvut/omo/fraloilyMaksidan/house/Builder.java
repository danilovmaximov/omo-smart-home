package cz.fel.cvut.omo.fraloilyMaksidan.house;

import cz.fel.cvut.omo.fraloilyMaksidan.house.floor.Floor;
import cz.fel.cvut.omo.fraloilyMaksidan.sensors.Sensor;

import java.util.List;

public interface Builder {
    HouseBuilder setAddress(String address);
    HouseBuilder addFloor(Floor floor);
    HouseBuilder addFloorAll(Floor... floors);
    HouseBuilder addFloorList(List<Floor> floors);
    HouseBuilder initFloors();
    HouseBuilder addSensors(Sensor... sensors);
    HouseBuilder addSensorsList(List<Sensor> sensors);
    House getResult();
}
