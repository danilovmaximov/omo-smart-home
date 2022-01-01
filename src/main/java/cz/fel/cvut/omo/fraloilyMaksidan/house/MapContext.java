package cz.fel.cvut.omo.fraloilyMaksidan.house;

import cz.fel.cvut.omo.fraloilyMaksidan.activities.Activity;
import cz.fel.cvut.omo.fraloilyMaksidan.entities.LivingEntity;

import java.util.ArrayList;
import java.util.List;

public class MapContext {
    private static List<Activity> activitiesInHouse = new ArrayList<>();
    private static List<LivingEntity> entitiesInHouse = new ArrayList<>();

    public static void addActivity(Activity activity) {
        activitiesInHouse.add(activity);
    }

    public static void addEntity(LivingEntity entity) {
        entitiesInHouse.add(entity);
    }

    public static List<Activity> getActivitiesInHouse() {
        return activitiesInHouse;
    }

    public static List<LivingEntity> getEntitiesInHouse() {
        return entitiesInHouse;
    }

    public static Boiler getTemperatureRaisers(boolean activeState) {
        for (Activity a : activitiesInHouse) {
            if (a instanceof Boiler b && b.isActive() == activeState) {
                return b;
            }
        }
        return null;
    }
}