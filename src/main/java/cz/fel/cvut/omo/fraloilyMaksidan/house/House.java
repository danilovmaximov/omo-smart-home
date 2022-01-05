package cz.fel.cvut.omo.fraloilyMaksidan.house;

import cz.fel.cvut.omo.fraloilyMaksidan.Context;
import cz.fel.cvut.omo.fraloilyMaksidan.activities.Activity;
import cz.fel.cvut.omo.fraloilyMaksidan.activities.ConsumingActivity;
import cz.fel.cvut.omo.fraloilyMaksidan.entities.LivingEntity;
import cz.fel.cvut.omo.fraloilyMaksidan.house.floor.Floor;
import cz.fel.cvut.omo.fraloilyMaksidan.sensors.Sensor;
import cz.fel.cvut.omo.fraloilyMaksidan.sensors.SensorsStation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class House {

    private String address;
    private final SensorsStation station = new SensorsStation();

    private final List<Floor> floors = new ArrayList<>();

    public void doActivities() {
        this.floors.forEach(floor -> floor.getRooms().forEach(room -> room.getActivities().forEach(Activity::step)));
    }

    public void appendConsumptionAndGetContextChange() {
        MapContext.getActivitiesInHouse().values().forEach(activity -> {
            if (activity instanceof ConsumingActivity a) {
                Context.getReports().getConsumptionReport()
                        .addTransaction(a.getCurrentTransaction());
            }
        });
    }

    public void activateSensors() {
        station.step();
    }

    public void moveEntities() {
        MapContext.getEntitiesInHouse().values().forEach(LivingEntity::step);
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void addFloor(Floor f) {
        this.floors.add(f);
    }

    public void addFloorAll(Floor... floors) {
        Arrays.stream(floors).
                forEach(this::addFloor);
    }

    public void addFloorList(List<Floor> floors) {
        floors
                .forEach(this::addFloor);
    }

    public void addSensors(Sensor... sensors) {
        Arrays.stream(sensors)
                .forEach(sensor -> this.station.addSensors(sensor));
    }

    public void addSensorsList(List<Sensor> sensors) {
        sensors
                .forEach(sensor -> this.station.addSensors(sensor));
    }

    public void initFloors() {
        for (Floor floor : floors) {
            floor.setHouse(this);
        }
    }

    public SensorsStation getStation() {
        return this.station;
    }

    @Override
    public String toString() {
        return "House: {\n" +
                "   address: " + address + ",\n" +
                "   " + station + "\n" +
                "   floors=" + Arrays.toString(floors.toArray()) + "\n" +
                "}";
    }
}
