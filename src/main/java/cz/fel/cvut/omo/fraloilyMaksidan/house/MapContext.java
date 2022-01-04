package cz.fel.cvut.omo.fraloilyMaksidan.house;

import cz.fel.cvut.omo.fraloilyMaksidan.activities.Activity;
import cz.fel.cvut.omo.fraloilyMaksidan.activities.BreakageManager;
import cz.fel.cvut.omo.fraloilyMaksidan.activities.contextmodifiers.Boiler;
import cz.fel.cvut.omo.fraloilyMaksidan.entities.LivingEntity;

import cz.fel.cvut.omo.fraloilyMaksidan.house.floor.Floor;
import cz.fel.cvut.omo.fraloilyMaksidan.house.room.Room;
import cz.fel.cvut.omo.fraloilyMaksidan.sensors.Sensor;

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

/**
 * Contains information about current house state.
 * Used to obtain current situation for changing searching, location change and so on.
 */
public class MapContext {
    private static House house;

    private static Map<String, Activity> activitiesInHouse = new HashMap<>();
    private static Map<String, LivingEntity> entitiesInHouse = new HashMap<>();
    private static Map<String, Room> roomsInHouse = new HashMap<>();
    private static Map<Integer, Floor> floorsInHouse = new HashMap<>();
    private static Map<String, Sensor> sensorsInHouse = new HashMap<>();

    private static Window houseWindows = new Window();
    private static Light houseLights = new Light();
    private static Humidifier houseHumidifier = new Humidifier();
    private static BreakageManager breakageManager = new BreakageManager("New breakage");

    public static void addActivity(Activity activity) {
        activitiesInHouse.put(activity.getName(), activity);
    }

    public static void addEntity(LivingEntity entity) {
        entitiesInHouse.put(entity.getName(), entity);
    }

    public static void addRoom(Room room) {
        roomsInHouse.put(room.getName(), room);
    }

    public static void addFloor(Floor floor) {
        floorsInHouse.put(floor.getFloorNumber(), floor);
    }

    public static void addSensors(Sensor... sensors) {
        Arrays.stream(sensors)
                        .forEach(sensor -> sensorsInHouse.put(sensor.getName(), sensor));
    }

    public static void setHouse(House _house) {
        house = _house;
    }

    public static Map<String, Activity> getActivitiesInHouse() {
        return activitiesInHouse;
    }

    public static Map<String, LivingEntity> getEntitiesInHouse() {
        return entitiesInHouse;
    }

    public static Map<String, Room> getRoomsInHouse() { return roomsInHouse; }

    public static Map<Integer, Floor> getFloorsInHouse() {
        return floorsInHouse;
    }

    public static Map<String, Sensor> getSensorsInHouse() {
        return sensorsInHouse;
    }

    public static Window getHouseWindows() {
        return houseWindows;
    }

    public static Light getHouseLights() {
        return houseLights;
    }

    public static Humidifier getHouseHumidifier() {
        return houseHumidifier;
    }

    public static BreakageManager getBreakageManager() {
        return breakageManager;
    }

    public static House getHouse() {
        return house;
    }

    public static Boiler getTemperatureRaisers(boolean activeState) {
        for (Activity a : activitiesInHouse.values()) {
            if (a instanceof Boiler b && b.isActive() == activeState) {
                return b;
            }
        }
        return null;
    }
}
