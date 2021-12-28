package cz.fel.cvut.omo.fraloilyMaksidan;

import cz.fel.cvut.omo.fraloilyMaksidan.reports.ReportsAPI;

public class Context {
    private static int lightLevel;
    private static int humidityLevel;
    private static ReportsAPI reports;
    private static int windSpeed;

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
