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
import cz.fel.cvut.omo.fraloilyMaksidan.enums.ExistingActivities;
import cz.fel.cvut.omo.fraloilyMaksidan.activities.contextmodifiers.Boiler;
import cz.fel.cvut.omo.fraloilyMaksidan.house.MapContext;
import cz.fel.cvut.omo.fraloilyMaksidan.house.room.Room;
import cz.fel.cvut.omo.fraloilyMaksidan.house.room.RoomBuilder;


public class Configurator {
    private static final String[] standardRooms = {
        "Kitchen", "Bedroom", "Child's room", "Living room", "Hall of grandad's fame", "Garage"
    };

    public static void createActivityAll(ExistingActivities... activities) throws RuntimeException {
        for (ExistingActivities activity : activities) {
            String name = activity.getName();
            switch (name) {
                case "CoffeeMaker3000":
                    MapContext.addActivity(new CoffeeMaker());
                    break;
                case "Computer":
                    MapContext.addActivity(new Computer());
                    break;
                case "Electric bike":
                    MapContext.addActivity(new ElectricBicycle());
                    break;
                case "TV":
                    MapContext.addActivity(new TV());
                    break;
                case "Couch":
                    MapContext.addActivity(new Couch());
                    break;
                case "Repair kit":
                    MapContext.addActivity(new RepairKit());
                    break;
                case "Boiler":
                    MapContext.addActivity(new Boiler());
                    break;
                default:
                    throw new RuntimeException("Trying to add unknown activity: " + name +
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
                    .setActivityList(MapContext.getActivitiesInHouse().stream()
                        .filter(activity -> activity.getStandardRoom() == roomName)
                        .toList())
                    .getResult()
            );
        }
    }

    public static void setEntitiesToRoom() {
        Room room = MapContext.getRoomsInHouse().get(0);
        MapContext.getEntitiesInHouse().stream().forEach(entity -> room.setEntity(entity));
    }
}
