package cz.fel.cvut.omo.fraloilyMaksidan.house;

import cz.fel.cvut.omo.fraloilyMaksidan.house.floor.Floor;
import cz.fel.cvut.omo.fraloilyMaksidan.senzors.EventManager;

import java.util.ArrayList;
import java.util.List;

public class House {

    private String address;
    private List<Floor> floors = new ArrayList<>();
    // TODO: where to place senzors?
    // We could use Iterable interface to store everuthing inside -- also not so smart
    // Also could be a part of a context?
    private List<EventManager> eventManagers = new ArrayList<>();

    public House(String address) {
        this.address = address;
    }

    public void addFloor(Floor f) {
        this.floors.add(f);
    }
    public void addSensors(EventManager m) {
        this.eventManagers.add(m);
    }

    public void step() {
        for(Floor f : floors){
            f.step();
        }
        // Not the smartest move:
        for(EventManager m : this.eventManagers) {
            m.step();
        }
    }
}
