package cz.fel.cvut.omo.fraloilyMaksidan;

import cz.fel.cvut.omo.fraloilyMaksidan.activities.Activity;
import cz.fel.cvut.omo.fraloilyMaksidan.reports.Reports;
import cz.fel.cvut.omo.fraloilyMaksidan.strategy.Strategy;

import java.util.ArrayList;
import java.util.List;

/**
 *  Contains parameters as temperature, light level and so on.
 *  Can be accessed from every place of application.
 */
public class Context {
    /* Broken activities context */
    private static final List<Activity> brokenActivities = new ArrayList<>();
    public static boolean hasSomethingBroken() {
        return !brokenActivities.isEmpty();
    }
    public static void addBrokenActivity(Activity activity) {
        brokenActivities.add(activity);
    }
    public static Activity getBrokenActivity() {
        Activity result = brokenActivities.get(0);
        brokenActivities.remove(0);
        return result;
    }
    private static Strategy currentStrategy;

    /* Oxygen level context */
    private static int oxygenLevel;
    public static int getOxygenLevel() {
        return oxygenLevel;
    }
    public static void setOxygenLevel(int oxygenLevel ) {
        Context.oxygenLevel = oxygenLevel;
    }
    public static void changeOxygenLevel(int change) {
        Context.oxygenLevel += change;
    }

    /* Inside temperature level context */
    private static int tempLevel;
    public static int getTempLevel() {
        return tempLevel;
    }
    public static void setTempLevel(int tempLevel ) {
        Context.tempLevel = tempLevel;
    }
    public static void changeTempLevel(int change) {
        Context.tempLevel += change;
    }

    /* Light context */
    private static boolean sunIsOut;
    private static int currentTime = 0;
    public static void nextHour() {
        if (currentTime == 23) {
            currentTime = 0;
        } else {
            currentTime += 1;
        }
    }
    public static int getCurrentTime() {
        return currentTime;
    }
    public static boolean itsBright() {
        return sunIsOut;
    }
    public static void setSun(boolean isOut) {
        sunIsOut = isOut;
    }

    /* Humidity level context */
    private static int humidityLevel;
    public static int getHumidityLevel() {
        return humidityLevel;
    }
    public static void setHumidityLevel(int humidityLevel) {
        Context.humidityLevel = humidityLevel;
    }
    public static void changeHumidityLevel(int change) {
        Context.humidityLevel += change;
    }

    /* Reports context */
    private static Reports reports = new Reports();
    public static Reports getReports() {
        return reports;
    }
    public static void setReports(Reports reports) {
        Context.reports = reports;
    }

    /* Strategy context */
    public static void setCurrentStrategy(Strategy currentStrategy) {
        Context.currentStrategy = currentStrategy;
    }
    public static Strategy getCurrentStrategy() {
        return currentStrategy;
    }
}
