package cz.fel.cvut.omo.fraloilyMaksidan.reports;

public class ReportsAPI {
    ActivityReporter activityReporter = new ActivityReporter();
    EventReport eventReport = new EventReport();
    HouseConfigurationReport houseConfigurationReport = new HouseConfigurationReport();

    public ActivityReporter getActivityReporter() {
        return activityReporter;
    }

    public EventReport getEventReport() {
        return eventReport;
    }

    public HouseConfigurationReport getHouseConfigurationReport() {
        return houseConfigurationReport;
    }
}
