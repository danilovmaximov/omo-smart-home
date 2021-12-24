package cz.fel.cvut.omo.fraloilyMaksidan.house;

import cz.fel.cvut.omo.fraloilyMaksidan.house.floor.Floor;
import cz.fel.cvut.omo.fraloilyMaksidan.reports.ActivityReporter;

import java.util.ArrayList;
import java.util.List;

public class House {

    private String address;
    private ActivityReporter actRep;
    private List<Floor> floors = new ArrayList<>();

    public House(String address, ActivityReporter actRep) {
        this.address = address;
        this.actRep = actRep;
    }

    public void addFloor(Floor f) {
        this.floors.add(f);
    }

    public void step() {
        for(Floor f : floors){
            f.step();
        }
    }
}
