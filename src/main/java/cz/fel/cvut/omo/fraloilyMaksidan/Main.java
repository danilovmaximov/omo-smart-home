package cz.fel.cvut.omo.fraloilyMaksidan;

import cz.fel.cvut.omo.fraloilyMaksidan.entities.Grandad;
import cz.fel.cvut.omo.fraloilyMaksidan.entities.activities.Activity;
import cz.fel.cvut.omo.fraloilyMaksidan.entities.activities.CoffeeMaker;
import cz.fel.cvut.omo.fraloilyMaksidan.house.House;
import cz.fel.cvut.omo.fraloilyMaksidan.house.floor.FloorBuilder;
import cz.fel.cvut.omo.fraloilyMaksidan.house.room.RoomBuilder;
import cz.fel.cvut.omo.fraloilyMaksidan.senzors.SunSensor;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        /*
           Configure context of application:
           Weather events, report classes...
         */
        var context = Context.getInstance();
        context.setLightLevel(69);
        context.setHumidityLevel(69);

        /*
           New appliances is created as separate classes...
         */
        var coffee3000 = new CoffeeMaker();

        /*
         * List of activities is passed to the person...
         */
        var activitiesForGrandad = new ArrayList<Activity>();
        activitiesForGrandad.add(coffee3000);
        var me = new Grandad("Ilya", activitiesForGrandad);

        /*
         * Builder is provided for structures of house: rooms, floors and co on...
         */
        var Kitchen = new RoomBuilder()
                .setName("Kitchen")
                .setActivityObjects(coffee3000)
                .setEntities(me)
                .getResult();

        var floor = new FloorBuilder()
                .setFloorNumber(1)
                .addRoom(Kitchen)
                .getResult();

        // TODO: add builder to house class.
        var house = new House("Street Lane 69");
        house.addFloor(floor);
        house.addSensors(new SunSensor());

        /*
         * World class is wrapper around house to provide different simulations...
         */
        World w1 = new World(house);
        w1.startSimulation(3);
        context.getReports().getActivityReporter().EntityToActivityMapping();
    }
}
