package cz.fel.cvut.omo.fraloilyMaksidan;

import cz.fel.cvut.omo.fraloilyMaksidan.entities.Father;
import cz.fel.cvut.omo.fraloilyMaksidan.entities.Grandad;
import cz.fel.cvut.omo.fraloilyMaksidan.entities.activities.staff.Activity;
import cz.fel.cvut.omo.fraloilyMaksidan.entities.activities.appliances.CoffeeMaker;
import cz.fel.cvut.omo.fraloilyMaksidan.entities.activities.staff.RepairKit;
import cz.fel.cvut.omo.fraloilyMaksidan.house.House;
import cz.fel.cvut.omo.fraloilyMaksidan.house.Window;
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
        context.setLightLevel(95);
        context.setHumidityLevel(95);

        /*
            New appliances is created as separate classes...
         */
        var coffee3000 = new CoffeeMaker();
        var repairKit = new RepairKit();

        /*
            List of activities is passed to the person...
         */
        var activitiesForGrandad = new ArrayList<Activity>();
        activitiesForGrandad.add(coffee3000);
        var me = new Grandad("Ilya", activitiesForGrandad);

        var activitiesForFather = new ArrayList<Activity>();
        activitiesForFather.add(coffee3000);
        activitiesForFather.add(repairKit);
        var otherMe = new Father("Dan", activitiesForFather);

        /*
            Builders are provided for structures of house: rooms, floors and co on...
         */
        var kitchen = new RoomBuilder()
                .setName("Kitchen")
                .setEntities(me)
                .setActivity(coffee3000)
                .setActivity(repairKit)
                .setEntities(otherMe)
                .getResult();

        var floor = new FloorBuilder()
                .setFloorNumber(1)
                .addRoom(kitchen)
                .initRooms()
                .getResult();

        var windowInTheKitchen = new Window();

        // TODO: add builder to house class.
        var house = new House("Street Lane 69");
        house.addFloor(floor);
        house.initFloors();

        // TODO: Нахуя?
        me.setHouse(house);
        otherMe.setHouse(house);

        //TODO: Нахуя?
        coffee3000.moveToTheRoom(kitchen);
        repairKit.moveToTheRoom(kitchen);

        /*
            Sensors are EventManagers, that are responding to context changes.
            For example, we can subscribe window for changing light level.
            Based on light level window can change its internal state...
         */
        var sunSensor = new SunSensor("LightUp", "LightDown");
        sunSensor.subscribe("LightUp", windowInTheKitchen);
        sunSensor.subscribe("LightDown", windowInTheKitchen);
        house.addSensors(sunSensor);

        /*
            World Class is a wrapper around house class to provide different simulations...
         */
        World w1 = new World(house);
        w1.startSimulation(30);

        /*
            Reports are used to deliver different info based on the demand;
         */
        var reports = context.getReports();
        System.out.println();
        reports.getActivityReporter().EntityToActivityMapping();
        System.out.println();
        reports.getEventReport().eventsBySource();
        System.out.println();
        reports.getHouseConfigurationReport().getConfiguration();
        System.out.println();
        reports.getConsumptionReport().getAllConsumptions();
        System.out.println();
    }
}
