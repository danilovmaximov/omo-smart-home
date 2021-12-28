package cz.fel.cvut.omo.fraloilyMaksidan;

import cz.fel.cvut.omo.fraloilyMaksidan.activities.staff.Activity;
import cz.fel.cvut.omo.fraloilyMaksidan.entities.LivingEntity;
import cz.fel.cvut.omo.fraloilyMaksidan.reports.ReportsAPI;

import java.util.ArrayList;
import java.util.List;

public class Context {
    private static int lightLevel;
    private static int humidityLevel;
    private static ReportsAPI reports = new ReportsAPI();
    private static int windSpeed;

    private static List<LivingEntity> control = new ArrayList<>();

    private static List<Activity> brokenActivities = new ArrayList<>();

    public static Activity getBrokenActivity() {
        Activity result = brokenActivities.get(0);
        brokenActivities.remove(0);
        return result;
    }

    public static void addEntity(LivingEntity entity) {
        control.add(entity);
    }

    public static void moveEntities() {
        control.forEach(LivingEntity::step);
    }

    public static void addBrokenActivity(Activity activity) { brokenActivities.add(activity); }
    public static boolean hasSomethingBroken() { return !brokenActivities.isEmpty(); }


    public static int getLightLevel() {
        return lightLevel;
    }

    public static void setLightLevel(int lightLevel) {
        Context.lightLevel = lightLevel;
    }

    public static int getHumidityLevel() {
        return humidityLevel;
    }

    public static void setHumidityLevel(int humidityLevel) {
        Context.humidityLevel = humidityLevel;
    }

    public static ReportsAPI getReports() {
        return reports;
    }

    public static void setReports(ReportsAPI reports) {
        Context.reports = reports;
    }

    public static int getWindSpeed() {
        return windSpeed;
    }

    public static void setWindSpeed(int windSpeed) {
        Context.windSpeed = windSpeed;
    }
}
