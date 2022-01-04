package cz.fel.cvut.omo.fraloilyMaksidan.reports;

public class Reports {
    final ActivityReporter activityReporter = new ActivityReporter();
    final EventReport eventReport = new EventReport();
    final HouseConfigurationReport houseConfigurationReport = new HouseConfigurationReport();
    final ConsumptionReport consumptionReport = new ConsumptionReport();

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
