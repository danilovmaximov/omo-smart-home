package cz.fel.cvut.omo.fraloilyMaksidan.house;

import java.util.ArrayList;
import java.util.List;

public class House {

    private String address;
    private int numberOfFloors;
    private List<Floor> floors = new ArrayList<>();
    private Garage garage;

    public void addFloor(Floor floor) {
        if(floors.size() > 4) {
            System.out.println("Sorry, no skyscrapers is allowed.");
            return;
        }
        floors.add(floor);
    }

    public void setGarage(Garage garage) {
        this.garage = garage;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void step() {
        for(Floor f : floors){

        }
    }
}
