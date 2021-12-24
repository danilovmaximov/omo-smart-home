package cz.fel.cvut.omo.fraloilyMaksidan.house;

import cz.fel.cvut.omo.fraloilyMaksidan.house.floor.Floor;

import java.util.ArrayList;
import java.util.List;

public class House {

    private String address;
    private List<Floor> floors = new ArrayList<>();

    public House(String address) {
        this.address = address;
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
