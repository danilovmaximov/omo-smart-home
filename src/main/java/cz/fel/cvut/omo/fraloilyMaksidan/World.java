package cz.fel.cvut.omo.fraloilyMaksidan;

import cz.fel.cvut.omo.fraloilyMaksidan.house.House;

public class World {

    private House house;
    private int lightLevel;
    private int humidityLevel;

    public World(House house, int lightLevel, int humidityLevel) {
        this.house = house;
        this.lightLevel = lightLevel;
        this.humidityLevel = humidityLevel;
    }

    public void startSimulation(int hours) {
        for(int i = 0; i < hours; ++i) {
            house.step();
        }
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }
}
