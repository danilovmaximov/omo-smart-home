package cz.fel.cvut.omo.fraloilyMaksidan.reports;

public class Reports {
    ActivityReporter activityReporter = new ActivityReporter();
    EventReport eventReport = new EventReport();
    HouseConfigurationReport houseConfigurationReport = new HouseConfigurationReport();
    ConsumptionReport consumptionReport = new ConsumptionReport();

    public ActivityReporter getActivityReporter() {
        return activityReporter;
    }

    public EventReport getEventReport() {
        return eventReport;
    }

    public ConsumptionReport getConsumptionReport() {
        return consumptionReport;
    }

    public HouseConfigurationReport getHouseConfigurationReport() {
        return houseConfigurationReport;
    }
}
