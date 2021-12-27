package cz.fel.cvut.omo.fraloilyMaksidan;

import cz.fel.cvut.omo.fraloilyMaksidan.reports.ReportsAPI;

public class Context {
    private int lightLevel;
    private int humidityLevel;
    private ReportsAPI reports;
    private int windSpeed;

    private static Context instance;

    private Context(int lightLevel, int humidityLevel, ReportsAPI reports) {
        this.lightLevel = lightLevel;
        this.humidityLevel = humidityLevel;
        this.reports = reports;
    }

    public int getLightLevel() {
        return lightLevel;
    }

    public void setLightLevel(int lightLevel) {
        this.lightLevel = lightLevel;
    }

    public int getHumidityLevel() {
        return humidityLevel;
    }

    public void setHumidityLevel(int humidityLevel) {
        this.humidityLevel = humidityLevel;
    }

    public ReportsAPI getReports() {
        return reports;
    }

    public void setReports(ReportsAPI reports) {
        this.reports = reports;
    }

    public int getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(int windSpeed) {
        this.windSpeed = windSpeed;
    }
    //  Context context = Context.getInstance();
    public static Context getInstance() {
        if(instance == null) {
            instance = new Context(50,50, new ReportsAPI());
        }
        return instance;
    }

    public void step() {
        //TODO: change context parameters according to could add strategy here
    }


}
