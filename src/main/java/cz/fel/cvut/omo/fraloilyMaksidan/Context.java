package cz.fel.cvut.omo.fraloilyMaksidan;

import cz.fel.cvut.omo.fraloilyMaksidan.activities.Activity;
import cz.fel.cvut.omo.fraloilyMaksidan.reports.Reports;

import java.util.ArrayList;
import java.util.List;

public class Context {
    /* Broken activities context */
    private static List<Activity> brokenActivities = new ArrayList<>();
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

    /* Oxygen level context */
    private static int oxygenLevel;
    public static int getOxygenLevel() {
        return oxygenLevel;
    }
    public static void setOxygenLevel(int oxygenLevel ) {
        Context.oxygenLevel = oxygenLevel;
    }

    /* Inside temperature level context */
    private static int tempLevel;
    public static int getTempLevel() {
        return tempLevel;
    }
    public static void setTempLevel(int tempLevel ) {
        Context.tempLevel = tempLevel;
    }

    /* Light context */
    private static boolean sunIsOut;
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

    /* Reports context */
    private static Reports reports = new Reports();
    public static Reports getReports() {
        return reports;
    }
    public static void setReports(Reports reports) {
        Context.reports = reports;
    }
}
