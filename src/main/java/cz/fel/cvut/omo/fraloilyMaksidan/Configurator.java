package cz.fel.cvut.omo.fraloilyMaksidan;

import cz.fel.cvut.omo.fraloilyMaksidan.activities.actions.Play;
import cz.fel.cvut.omo.fraloilyMaksidan.activities.actions.RememberGoodTimes;
import cz.fel.cvut.omo.fraloilyMaksidan.activities.actions.Sleep;
import cz.fel.cvut.omo.fraloilyMaksidan.activities.appliances.CoffeeMaker;
import cz.fel.cvut.omo.fraloilyMaksidan.activities.appliances.Computer;
import cz.fel.cvut.omo.fraloilyMaksidan.activities.appliances.ElectricBicycle;
import cz.fel.cvut.omo.fraloilyMaksidan.activities.appliances.TV;
import cz.fel.cvut.omo.fraloilyMaksidan.activities.staff.Couch;
import cz.fel.cvut.omo.fraloilyMaksidan.activities.staff.RepairKit;
import cz.fel.cvut.omo.fraloilyMaksidan.entities.Father;
import cz.fel.cvut.omo.fraloilyMaksidan.entities.LivingEntity;
import cz.fel.cvut.omo.fraloilyMaksidan.enums.ExistingActivities;
import cz.fel.cvut.omo.fraloilyMaksidan.activities.contextmodifiers.Boiler;
import cz.fel.cvut.omo.fraloilyMaksidan.house.HouseBuilder;
import cz.fel.cvut.omo.fraloilyMaksidan.house.MapContext;
import cz.fel.cvut.omo.fraloilyMaksidan.house.floor.FloorBuilder;
import cz.fel.cvut.omo.fraloilyMaksidan.house.room.Room;
import cz.fel.cvut.omo.fraloilyMaksidan.house.room.RoomBuilder;
import cz.fel.cvut.omo.fraloilyMaksidan.sensors.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Configurator {
    private static final String[] standardRooms = {
            "Kitchen", "Bedroom", "Child's room", "Living room", "Hall of grandad's fame", "Garage"
    };
    private static final int[] standardFloors = {1, 2};

    /* NOTE: I have a suspicion this block of code is a disaster. */
    private static final Map<Integer, List<String>> floorToRooms = new HashMap<>() {{
        put(1, new ArrayList<>(List.of("Kitchen", "Living room", "Garage")));
        put(2, new ArrayList<>(List.of("Bedroom", "Child's room", "Hall of grandad's game")));
    }};

    public static void createActivityAll(ExistingActivities... activities) throws RuntimeException {
        for (ExistingActivities activity : activities) {
            String name = activity.getName();
            switch (name) {
                case "CoffeeMaker3000" -> MapContext.addActivity(new CoffeeMaker());
                case "Computer" -> MapContext.addActivity(new Computer());
                case "Electric bike" -> MapContext.addActivity(new ElectricBicycle());
                case "TV" -> MapContext.addActivity(new TV());
                case "Couch" -> MapContext.addActivity(new Couch());
                case "Repair kit" -> MapContext.addActivity(new RepairKit());
                case "Boiler" -> MapContext.addActivity(new Boiler());
                default -> throw new RuntimeException("Trying to add unknown activity: " + name +
                        ". Play, Sleep and other personal activities are added automatically.");
            }
        }

        MapContext.addActivity(new Sleep());
        MapContext.addActivity(new Play());
        MapContext.addActivity(new RememberGoodTimes());
    }

    public static void createStandardRooms() {
        for (String roomName : standardRooms) {
            MapContext.addRoom(
                    new RoomBuilder()
                            .setName(roomName)
                            .setActivityList(MapContext.getActivitiesInHouse().values().stream()
                                    .filter(activity -> activity.getStandardRoomName() == roomName)
                                    .toList())
                            .getResult()
            );
        }
    }

    public static void setUnattachedActivitiesToRooms() {
        Room randomRoom = MapContext.getRoomsInHouse().get(0);
        MapContext.getActivitiesInHouse().values().stream()
                .filter(activity -> activity.getRoom() == null)
                .forEach(activity -> randomRoom.setActivity(activity));
    }

    public static void setEntitiesToRoom() {
        Room room = MapContext.getRoomsInHouse().values().stream().findFirst().get();
        MapContext.getEntitiesInHouse().values().stream().forEach(entity -> room.setEntity(entity));
    }

    public static void createStandardFloors() {
        for (int floorNum : standardFloors) {
            MapContext.addFloor(
                    new FloorBuilder()
                            .setFloorNumber(floorNum)
                            .addRoomList(
                                    MapContext.getRoomsInHouse().values().stream()
                                            .filter(room -> floorToRooms.get(floorNum).contains(room.getName()))
                                            .toList()
                            )
                            .initRooms()
                            .getResult()
            );
        }
    }

    /*
       Sensors are EventManagers, that are responding to context changes.
       For example, we can subscribe window for changing light level.
       Based on light level window can change its internal state...
    */
    public static void createStandardSensors() {
        var sunSensor = new SunSensor("LightUp", "LightDown");
        sunSensor.subscribe("LightUp", MapContext.getHouseWindows(), MapContext.getHouseLights());
        sunSensor.subscribe("LightDown", MapContext.getHouseWindows(), MapContext.getHouseLights());

        var oxygenSensor = new OxygenSensor("OxygenLow", "OxygenHigh");
        oxygenSensor.subscribe("OxygenLow", MapContext.getHouseWindows());
        oxygenSensor.subscribe("OxygenHigh", MapContext.getHouseWindows());

        var humiditySensor = new HumiditySensor("AirIsDry", "AirIsWet");
        humiditySensor.subscribe("AirIsDry", MapContext.getHouseHumidifier());
        humiditySensor.subscribe("AirIsWet", MapContext.getHouseHumidifier());

        var insideTempSensor = new TempSensor("ItsCold", "ItsWarm");
        for (LivingEntity entity : MapContext.getEntitiesInHouse().values()) {
            if (entity instanceof Father) {
                insideTempSensor.subscribe("ItsCold", (Father) entity);
                insideTempSensor.subscribe("ItsWarm", (Father) entity);
                break;
            }
        }

        MapContext.addSensors(sunSensor, oxygenSensor, humiditySensor, insideTempSensor);
    }

    public static void createStandardHouse() {
        MapContext.setHouse(new HouseBuilder()
                .setAddress("Street Lane 69")
                .addFloorList(MapContext.getFloorsInHouse().values().stream().toList())
                .initFloors()
                .addSensorsList(MapContext.getSensorsInHouse().values().stream().toList())
                .getResult()
        );
    }
}
