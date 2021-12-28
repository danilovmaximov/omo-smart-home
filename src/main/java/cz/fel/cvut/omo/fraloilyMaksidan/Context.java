package cz.fel.cvut.omo.fraloilyMaksidan;

import cz.fel.cvut.omo.fraloilyMaksidan.activities.staff.Activity;
import cz.fel.cvut.omo.fraloilyMaksidan.entities.LivingEntity;
import cz.fel.cvut.omo.fraloilyMaksidan.reports.ReportsAPI;

import java.util.ArrayList;
import java.util.List;

public class Context {
    /* Broken activities context */
    private static List<Activity> brokenActivities = new ArrayList<>();
    public static boolean hasSomethingBroken() { return !brokenActivities.isEmpty(); }
    public static void addBrokenActivity(Activity activity) { brokenActivities.add(activity); }
    public static Activity getBrokenActivity() {
        Activity result = brokenActivities.get(0);
        brokenActivities.remove(0);
        return result;
    }

    /* Entities context */
    private static List<LivingEntity> entitiesInHouse = new ArrayList<>();
    public static void addEntity(LivingEntity entity) { entitiesInHouse.add(entity); }
    public static void moveEntities() { entitiesInHouse.forEach(LivingEntity::step); }

    /* Temperature context */
    private static int tempLevel;
    public static int getTempLevel() { return tempLevel; }
    public static void setTempLevel(int tempLevel ) { Context.tempLevel = tempLevel; }

    /* Light level context */
    private static int lightLevel;
    public static int getLightLevel() { return lightLevel; }
    public static void setLightLevel(int lightLevel) { Context.lightLevel = lightLevel; }

    /* Wind context */
    private static int windSpeed;
    public static int getWindSpeed() { return windSpeed; }
    public static void setWindSpeed(int windSpeed) { Context.windSpeed = windSpeed; }

    /* Humidity level context */
    private static int humidityLevel;
    public static int getHumidityLevel() { return humidityLevel; }
    public static void setHumidityLevel(int humidityLevel) { Context.humidityLevel = humidityLevel; }

    /* Reports context */
    private static ReportsAPI reports = new ReportsAPI();
    public static ReportsAPI getReports() { return reports; }
    public static void setReports(ReportsAPI reports) { Context.reports = reports; }
}
