package cz.fel.cvut.omo.fraloilyMaksidan.house;

import cz.fel.cvut.omo.fraloilyMaksidan.activities.staff.Activity;
import cz.fel.cvut.omo.fraloilyMaksidan.house.floor.Floor;
import cz.fel.cvut.omo.fraloilyMaksidan.sensors.EventManager;
import cz.fel.cvut.omo.fraloilyMaksidan.sensors.Sensor;
import cz.fel.cvut.omo.fraloilyMaksidan.sensors.SensorsStation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class House {

    private String address;
    private SensorsStation station;
    private List<Floor> floors = new ArrayList<>();
    private List<EventManager> eventManagers = new ArrayList<>();
    private List<Activity> brokenActivities = new ArrayList<>();

    public int getFloorsNum() { return this.floors.size(); }
    public Floor getFloor(int i) { return this.floors.get(i); }

    public void setAddress(String address) { this.address = address; }
    public void addFloor(Floor f) {
        this.floors.add(f);
    }
    public void addSensor(Sensor... sensors) {
        this.station = new SensorsStation(sensors);
    }

    public void initFloors() {
        for (Floor floor : floors) {
            floor.setHouse(this);
        }
    }

    public void step() {
        for(Floor f : floors){
            f.step();
        }
        station.step();
    }

    public void addBrokenActivity(Activity activity) { this.brokenActivities.add(activity); }
    public boolean hasSomethingBroken() { return !this.brokenActivities.isEmpty(); }
    public Activity getBrokenActivity() {
        Activity result = this.brokenActivities.get(0);
        this.brokenActivities.remove(0);
        return result;
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
