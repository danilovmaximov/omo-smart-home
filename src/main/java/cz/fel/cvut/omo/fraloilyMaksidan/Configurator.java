package cz.fel.cvut.omo.fraloilyMaksidan;

import cz.fel.cvut.omo.fraloilyMaksidan.activities.Activity;
import cz.fel.cvut.omo.fraloilyMaksidan.activities.actions.Play;
import cz.fel.cvut.omo.fraloilyMaksidan.activities.actions.RememberGoodTimes;
import cz.fel.cvut.omo.fraloilyMaksidan.activities.actions.Sleep;
import cz.fel.cvut.omo.fraloilyMaksidan.activities.actions.Walk;
import cz.fel.cvut.omo.fraloilyMaksidan.activities.actions.cat.Hum;
import cz.fel.cvut.omo.fraloilyMaksidan.activities.actions.cat.JumpAround;
import cz.fel.cvut.omo.fraloilyMaksidan.activities.actions.cat.Wash;
import cz.fel.cvut.omo.fraloilyMaksidan.activities.actions.dog.Bark;
import cz.fel.cvut.omo.fraloilyMaksidan.activities.actions.dog.ChaseTheTail;
import cz.fel.cvut.omo.fraloilyMaksidan.activities.actions.dog.PlayBall;
import cz.fel.cvut.omo.fraloilyMaksidan.activities.actions.fish.Bloop;
import cz.fel.cvut.omo.fraloilyMaksidan.activities.actions.fish.Drip;
import cz.fel.cvut.omo.fraloilyMaksidan.activities.actions.fish.Splash;
import cz.fel.cvut.omo.fraloilyMaksidan.activities.appliances.*;
import cz.fel.cvut.omo.fraloilyMaksidan.activities.staff.Couch;
import cz.fel.cvut.omo.fraloilyMaksidan.activities.staff.RepairKit;
import cz.fel.cvut.omo.fraloilyMaksidan.activities.staff.Skis;
import cz.fel.cvut.omo.fraloilyMaksidan.entities.*;
import cz.fel.cvut.omo.fraloilyMaksidan.enums.ExistingActivities;
import cz.fel.cvut.omo.fraloilyMaksidan.activities.contextmodifiers.Boiler;
import cz.fel.cvut.omo.fraloilyMaksidan.house.HouseBuilder;
import cz.fel.cvut.omo.fraloilyMaksidan.house.MapContext;
import cz.fel.cvut.omo.fraloilyMaksidan.house.floor.Floor;
import cz.fel.cvut.omo.fraloilyMaksidan.house.floor.FloorBuilder;
import cz.fel.cvut.omo.fraloilyMaksidan.house.room.Room;
import cz.fel.cvut.omo.fraloilyMaksidan.house.room.RoomBuilder;
import cz.fel.cvut.omo.fraloilyMaksidan.parsing.models.ActivityModel;
import cz.fel.cvut.omo.fraloilyMaksidan.parsing.models.EntityModel;
import cz.fel.cvut.omo.fraloilyMaksidan.parsing.models.FloorModel;
import cz.fel.cvut.omo.fraloilyMaksidan.parsing.models.HouseModel;
import cz.fel.cvut.omo.fraloilyMaksidan.sensors.*;

import java.util.*;


public class Configurator {

    /**
        Creating house configuration from JSON file.
     */
    private static List<Room> createRoomsList(List<String> roomsList) {
        List<Room> resultList = new ArrayList<>();
        roomsList.forEach(
            roomName -> resultList.add(new RoomBuilder()
                    .setName(roomName)
                    .getResult())
        );
        resultList.forEach(MapContext::addRoom);
        return resultList;
    }

    public static void createFloorsFromJSON(List<FloorModel> floorModels) throws RuntimeException {
        if (floorModels == null) {
            throw new RuntimeException("No floors received from JSON.");
        }

        for (FloorModel floorModel : floorModels) {
            List<Room> roomsList = createRoomsList(floorModel.getRooms());
            MapContext.addFloor(new FloorBuilder()
                    .setFloorNumber(floorModel.getFloorNumber())
                    .addRoomList(roomsList)
                    .initRooms()
                    .getResult()
            );
        }
    }

    /**
        Sensors are EventManagers, that are responding to context changes.
        For example, we can subscribe window for changing light level.
        Based on light level window can change its internal state...
    */
    public static void createStandardSensors() {
        var sunSensor = new SunSensor("Sunlight sensor","LightUp", "LightDown");
        sunSensor.subscribe("LightUp", MapContext.getHouseWindows(), MapContext.getHouseLights());
        sunSensor.subscribe("LightDown", MapContext.getHouseWindows(), MapContext.getHouseLights());

        var oxygenSensor = new OxygenSensor("Oxygen level sensor", "OxygenLow", "OxygenHigh");
        oxygenSensor.subscribe("OxygenLow", MapContext.getHouseWindows());
        oxygenSensor.subscribe("OxygenHigh", MapContext.getHouseWindows());

        var humiditySensor = new HumiditySensor("Humidity level sensor", "AirIsDry", "AirIsWet");
        humiditySensor.subscribe("AirIsDry", MapContext.getHouseHumidifier());
        humiditySensor.subscribe("AirIsWet", MapContext.getHouseHumidifier());

        var insideTempSensor = new TempSensor("Inside temperature sensor", "Its cold", "Its warm");
        for (LivingEntity entity : MapContext.getEntitiesInHouse().values()) {
            if (entity instanceof Father) {
                insideTempSensor.subscribe("Its cold", (Father) entity);
                insideTempSensor.subscribe("Its warm", (Father) entity);

                // We also need to subscribe Father to BreakageManager, so we will do it here
                // not to look for him twice.
                MapContext.getBreakageManager().subscribe("New breakage", (Father) entity);
                break;
            }
        }

        MapContext.addSensors(sunSensor, oxygenSensor, humiditySensor, insideTempSensor);
        MapContext.getHouse().addSensorsList(MapContext.getSensorsInHouse().values().stream().toList());
    }

    public static void createHouseFromJSON(HouseModel houseModel) throws RuntimeException {
        if (houseModel == null) {
            throw new RuntimeException("No house model received from JSON.");
        }

        MapContext.setHouse(new HouseBuilder()
                .setAddress(houseModel.getAddress())
                .addFloorList(MapContext.getFloorsInHouse().values().stream().toList())
                .initFloors()
                .getResult()
        );
    }

    public static void createActivitiesFromJSON(List<ActivityModel> activityModels) throws RuntimeException {
        if (activityModels == null) {
            throw new RuntimeException("No activities received from JSON.");
        }

        for (ActivityModel activityModel : activityModels) {
            Activity newActivity;
            switch (activityModel.getName()) {
                case "CoffeeMaker3000" -> newActivity = new CoffeeMaker();
                case "Computer" -> newActivity = new Computer();
                case "Electric bike" -> newActivity = new ElectricBicycle();
                case "TV" -> newActivity = new TV();
                case "Couch" -> newActivity = new Couch();
                case "Repair kit" -> newActivity = new RepairKit();
                case "Boiler" -> newActivity = new Boiler();
                case "Sleep" -> newActivity = new Sleep();
                case "Play" -> newActivity = new Play();
                case "Skis" -> newActivity = new Skis();
                case "Washing machine" -> newActivity = new WashingMachine();
                case "Treadmill" -> newActivity = new Treadmill();
                case "Kitchen stove" -> newActivity = new KitchenStove();
                case "Car" -> newActivity = new Car();
                case "Audio system" -> newActivity = new AudioSystem();
                case "Walk" -> newActivity = new Walk();
                case "Bloop" -> newActivity = new Bloop();
                case "Drip" -> newActivity = new Drip();
                case "Splash" -> newActivity = new Splash();
                case "Bark" -> newActivity = new Bark();
                case "Chase the tail" -> newActivity = new ChaseTheTail();
                case "Play ball" -> newActivity = new PlayBall();
                case "Hum" -> newActivity = new Hum();
                case "Jump around" -> newActivity = new JumpAround();
                case "Wash" -> newActivity = new Wash();
                case "Remember good times" -> newActivity = new RememberGoodTimes();
                default -> throw new RuntimeException("Trying to add unknown activity: " + activityModel.getName());
            }

            Room activityRoom = MapContext.getRoomsInHouse().get(activityModel.getRoom());
            if (activityRoom != null) {
                activityRoom.setActivity(newActivity);
                newActivity.setRoom(activityRoom);
                MapContext.addActivity(newActivity);
            } else {
                throw new RuntimeException("Nonexistent room: " + activityModel.getRoom() +
                                           ", for activity: " + activityModel.getName());
            }
        }
    }

    public static void createEntitiesFromJSON(List<EntityModel> entityModels) throws RuntimeException {
        if (entityModels == null) {
            throw new RuntimeException("No entities received from JSON.");
        }

        for (EntityModel entityModel : entityModels) {
            List<Activity> activities = new ArrayList<>();
            entityModel.getActivities()
                    .forEach(activityName -> activities.add(MapContext.getActivitiesInHouse().get(activityName)));

            LivingEntity newEntity;
            switch (entityModel.getType()) {
                case "Father" -> newEntity = new Father(entityModel.getName(), activities);
                case "Mother" -> newEntity = new Mother(entityModel.getName(), activities);
                case "Grandfather" -> newEntity = new Grandfather(entityModel.getName(), activities);
                case "Baby" -> newEntity = new Baby(entityModel.getName(), activities);
                case "Grandmother" -> newEntity = new Grandmother(entityModel.getName(), activities);
                case "Cat" -> newEntity = new Cat(entityModel.getName(), activities);
                case "Dog" -> newEntity = new Dog(entityModel.getName(), activities);
                case "Fishy" -> newEntity = new Fishy(entityModel.getName(), activities);
                default -> throw new RuntimeException("Unknown entity type: " + entityModel.getType());
            }
            MapContext.addEntity(newEntity);
        }

        Room randomRoom = MapContext.getRoomsInHouse().values().stream().findAny().orElse(null);
        if (randomRoom != null) {
            MapContext.getEntitiesInHouse().values()
                    .forEach(entity -> {
                            entity.setRoom(randomRoom);
                            randomRoom.setEntity(entity);
                        }
                    );
        } else {
            throw new RuntimeException("No rooms in house to put entities into.");
        }

        List<Mother> mothers = MapContext.getEntitiesInHouse().values().stream()
                .filter(entity -> entity instanceof Mother)
                .map(entity -> (Mother) entity)
                .toList();
        List<Baby> babies = MapContext.getEntitiesInHouse().values().stream()
                .filter(entity -> entity instanceof Baby)
                .map(entity -> (Baby) entity)
                .toList();
        mothers.forEach(
                mother -> babies.forEach(baby -> mother.addBabies(baby))
        );

        List<Grandmother> grannys = MapContext.getEntitiesInHouse().values().stream()
                .filter(entity -> entity instanceof Grandmother)
                .map(entity -> (Grandmother) entity)
                .toList();
        List<Cat> cats = MapContext.getEntitiesInHouse().values().stream()
                .filter(entity -> entity instanceof Cat)
                .map(entity -> (Cat) entity)
                .toList();
        List<Dog> dogs = MapContext.getEntitiesInHouse().values().stream()
                .filter(entity -> entity instanceof Dog)
                .map(entity -> (Dog) entity)
                .toList();

        grannys.forEach(
                granny -> cats.forEach(cat -> granny.addCats(cat))
        );
        cats.forEach(
                cat -> dogs.forEach(dog -> cat.addDogs(dog))
        );
    }


    /*
        Creating standard house configuration from main function.
    */

    private static final String[] standardRooms = {
            "Kitchen", "Bedroom", "Child's room", "Living room", "Hall of grandad's fame", "Garage"
    };
    private static final int[] standardFloors = {1, 2};

    /* NOTE: I have a suspicion this block of code is a disaster. */
    private static final Map<Integer, List<String>> floorToRooms = new HashMap<>() {{
        put(1, new ArrayList<>(List.of("Kitchen", "Living room", "Garage")));
        put(2, new ArrayList<>(List.of("Bedroom", "Child's room", "Hall of grandad's fame")));
    }};

    public static void moveActivityToRoom(ExistingActivities activityEntity, String roomName) throws RuntimeException {
        Activity activity = MapContext.getActivitiesInHouse().get(activityEntity.getName());
        if (activity != null) {
            if (activity.getRoom() != null) activity.getRoom().removeActivity(activity);
            Room newRoom = MapContext.getRoomsInHouse().get(roomName);
            if (newRoom != null) {
                activity.setRoom(newRoom);
                newRoom.setActivity(activity);
            } else {
                throw new RuntimeException("Moving " + activity + " to invalid room: " +  roomName);
            }
        } else {
            throw new RuntimeException("No activity in house: " + activityEntity);
        }
    }

    public static void moveRoomToFloor(String roomName, int floorNum) throws RuntimeException {
        Room room = MapContext.getRoomsInHouse().get(roomName);
        if (room != null) {
            Floor floor = MapContext.getFloorsInHouse().get(floorNum);
            if (floor != null) {
                room.moveToFloor(floor);
            } else {
                throw new RuntimeException("No floor " + floorNum + " in the house");
            }
        } else {
            throw new RuntimeException("No room " + roomName + " in the house");
        }
    }

    public static void createActivitiesAll(String... activitiesNames) throws RuntimeException {
        for (String activityName : activitiesNames) {
            switch (activityName) {
                case "CoffeeMaker3000" -> MapContext.addActivity(new CoffeeMaker());
                case "Computer" -> MapContext.addActivity(new Computer());
                case "Electric bike" -> MapContext.addActivity(new ElectricBicycle());
                case "TV" -> MapContext.addActivity(new TV());
                case "Couch" -> MapContext.addActivity(new Couch());
                case "Repair kit" -> MapContext.addActivity(new RepairKit());
                case "Boiler" -> MapContext.addActivity(new Boiler());
                default -> throw new RuntimeException("Trying to add unknown activity: " + activityName +
                        ". Play, Sleep and other action activities are added automatically.");
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
                                    .filter(activity -> Objects.equals(activity.getStandardRoomName(), roomName))
                                    .toList())
                            .getResult()
            );
        }
    }

    public static void setUnattachedActivitiesToRooms() throws RuntimeException {
        Room randomRoom = MapContext.getRoomsInHouse().values().stream().findAny().orElse(null);
        if (randomRoom == null) {
            throw new RuntimeException("No rooms found in the house!");
        }
        MapContext.getActivitiesInHouse().values().stream()
                .filter(activity -> activity.getRoom() == null)
                .forEach(randomRoom::setActivity);
    }

    public static void setEntitiesToRoom() throws RuntimeException {
        Room room = MapContext.getRoomsInHouse().values().stream().findAny().orElse(null);
        if (room == null) {
            throw new RuntimeException("No rooms found in the house!");
        }
        MapContext.getEntitiesInHouse().values().forEach(room::setEntity);
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
