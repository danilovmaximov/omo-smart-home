package cz.fel.cvut.omo.fraloilyMaksidan;

import cz.fel.cvut.omo.fraloilyMaksidan.entities.Grandad;
import cz.fel.cvut.omo.fraloilyMaksidan.entities.activities.Activity;
import cz.fel.cvut.omo.fraloilyMaksidan.entities.activities.CoffeeMaker;
import cz.fel.cvut.omo.fraloilyMaksidan.house.House;
import cz.fel.cvut.omo.fraloilyMaksidan.house.floor.FloorBuilder;
import cz.fel.cvut.omo.fraloilyMaksidan.house.room.RoomBuilder;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        var context = Context.getInstance();
        context.setLightLevel(69);
        context.setHumidityLevel(69);
        var coffee3000 = new CoffeeMaker();
        var activitiesForGrandad = new ArrayList<Activity>();
        activitiesForGrandad.add(coffee3000);

        var me = new Grandad("Ilya", activitiesForGrandad);

        var Kitchen = new RoomBuilder()
                .setName("Kitchen")
                .setActivityObjects(coffee3000)
                .setEntities(me)
                .getResult();

        var floor = new FloorBuilder()
                .setFloorNumber(1)
                .addRoom(Kitchen)
                .getResult();

        var house = new House("Street Lane 69");

        house.addFloor(floor);


        World w1 = new World(house);
        w1.startSimulation(3);
        context.getReports().getActivityReporter().EntityToActivityMapping();
    }
}
