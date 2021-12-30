package cz.fel.cvut.omo.fraloilyMaksidan.house;

import cz.fel.cvut.omo.fraloilyMaksidan.Context;
import cz.fel.cvut.omo.fraloilyMaksidan.activities.Activity;
import cz.fel.cvut.omo.fraloilyMaksidan.activities.ApplianceActivity;
import cz.fel.cvut.omo.fraloilyMaksidan.entities.LivingEntity;
import cz.fel.cvut.omo.fraloilyMaksidan.house.floor.Floor;
import cz.fel.cvut.omo.fraloilyMaksidan.sensors.Sensor;
import cz.fel.cvut.omo.fraloilyMaksidan.sensors.SensorsStation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class House {

    private String address;
    private SensorsStation station;
    private final List<Floor> floors = new ArrayList<>();
    private List<Activity> activitiesInHouse = new ArrayList<>();
    private List<LivingEntity> entitiesInHouse = new ArrayList<>();

    public void initHouseContext() {
        //sad but true
        floors.forEach(floor -> {
            floor.getRooms().forEach(room -> {
                activitiesInHouse.addAll(room.getActivities());
                entitiesInHouse.addAll(room.getEntities());
            });
        });
    }

    public void doActivities() {
        activitiesInHouse.forEach(Activity::step);
    }

    public void appendConsumption() {
        activitiesInHouse.forEach(activity -> {
            if(activity instanceof ApplianceActivity a) {
                Context.getReports().getConsumptionReport()
                        .addTransaction(a.getCurrentTransaction());
            }
        });
    }

    public void activateSensors() {
        station.step();
    }

    public void moveEntities() {
        entitiesInHouse.forEach(LivingEntity::step);
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void addFloor(Floor f) {
        this.floors.add(f);
    }

    public void addSensors(Sensor... sensors) {
        for (Sensor sensor : sensors) {
            this.station = new SensorsStation(sensor);
        }
    }

    public void initFloors() {
        for (Floor floor : floors) {
            floor.setHouse(this);
        }
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
