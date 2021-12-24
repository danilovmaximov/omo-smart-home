package cz.fel.cvut.omo.fraloilyMaksidan;

import cz.fel.cvut.omo.fraloilyMaksidan.reports.ReportsAPI;

public class Context {
    private int lightLevel;
    private int humidityLevel;
    private ReportsAPI reports;

    private static Context instance;

    private Context(int lightLevel, int humidityLevel, ReportsAPI reports) {
        this.lightLevel = lightLevel;
        this.humidityLevel = humidityLevel;
        this.reports = reports;
    }

    public int getLightLevel() {
        return lightLevel;
    }

    public int getHumidityLevel() {
        return humidityLevel;
    }

    public ReportsAPI getReports() {
        return reports;
    }

    public void setLightLevel(int lightLevel) {
        this.lightLevel = lightLevel;
    }

    public void setHumidityLevel(int humidityLevel) {
        this.humidityLevel = humidityLevel;
    }

    public void setReports(ReportsAPI reports) {
        this.reports = reports;
    }

    public static Context getInstance() {
        if(instance == null) {
            instance = new Context(50,50, new ReportsAPI());
        }
        return instance;
    }


}
