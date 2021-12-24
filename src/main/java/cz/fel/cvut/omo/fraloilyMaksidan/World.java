package cz.fel.cvut.omo.fraloilyMaksidan;

import cz.fel.cvut.omo.fraloilyMaksidan.house.House;

public class World {

    private House house;
    private Context context = Context.getInstance();

    public World(House house) {
        this.house = house;
    }

    public void startSimulation(int hours) {
        context.step();
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
