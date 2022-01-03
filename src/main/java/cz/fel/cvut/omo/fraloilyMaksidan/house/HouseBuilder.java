package cz.fel.cvut.omo.fraloilyMaksidan.house;

import cz.fel.cvut.omo.fraloilyMaksidan.house.floor.Floor;
import cz.fel.cvut.omo.fraloilyMaksidan.sensors.Sensor;
import java.util.List;

public class HouseBuilder implements Builder {
    House house = new House();

    @Override
    public void reset() {
        // TODO: implement this
    }

    @Override
    public HouseBuilder setAddress(String address) {
        house.setAddress(address);
        return this;
    }

    @Override
    public HouseBuilder addFloor(Floor floor) {
        house.addFloor(floor);
        return this;
    }

    @Override
    public HouseBuilder addFloorAll(Floor... floors) {
        house.addFloorAll(floors);
        return this;
    }

    @Override
    public HouseBuilder addFloorList(List<Floor> floors) {
        house.addFloorList(floors);
        return this;
    }

    @Override
    public HouseBuilder initFloors() {
        house.initFloors();
        return this;
    }

    @Override
    public HouseBuilder addSensors(Sensor... sensors) {
        house.addSensors(sensors);
        return this;
    }

    @Override
    public HouseBuilder addSensorsList(List<Sensor> sensors) {
        house.addSensorsList(sensors);
        return this;
    }

    @Override
    public House getResult() {
        return this.house;
    }
}
