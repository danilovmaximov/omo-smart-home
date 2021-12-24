package cz.fel.cvut.omo.fraloilyMaksidan.house;

import cz.fel.cvut.omo.fraloilyMaksidan.house.floor.Floor;
import cz.fel.cvut.omo.fraloilyMaksidan.senzors.EventManager;
import cz.fel.cvut.omo.fraloilyMaksidan.senzors.SensorsStation;

import java.util.ArrayList;
import java.util.List;

public class House {

    private String address;
    private SensorsStation station;
    private List<Floor> floors = new ArrayList<>();
    private List<EventManager> eventManagers = new ArrayList<>();

    public House(String address) {
        this.address = address;
    }

    public void addFloor(Floor f) {
        this.floors.add(f);
    }
    public void addSensors(EventManager... sensors) {
        this.station = new SensorsStation(sensors);
    }

    public void step() {
        for(Floor f : floors){
            f.step();
        }
        station.step();
    }
}
