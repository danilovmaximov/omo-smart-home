package cz.fel.cvut.omo.fraloilyMaksidan;

import cz.fel.cvut.omo.fraloilyMaksidan.house.House;

public class World {

    private House house;

    public World(House house) {
        this.house = house;
        Context.getReports().getHouseConfigurationReport().setHouse(house);
    }

    public void startSimulation(int hours) {
        for(int i = 0; i < hours; ++i) {
            ChangeContext();
            Context.moveEntities();
            house.step();
        }
    }

    private void ChangeContext() {

    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }
}
