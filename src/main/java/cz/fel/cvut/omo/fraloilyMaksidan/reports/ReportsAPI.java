package cz.fel.cvut.omo.fraloilyMaksidan.reports;

import cz.fel.cvut.omo.fraloilyMaksidan.senzors.EventManager;

public class ReportsAPI {
    ActivityReporter activityReporter = new ActivityReporter();
    EventReport eventReport = new EventReport();

    public ActivityReporter getActivityReporter() {
        return activityReporter;
    }

    public EventReport getEventReport() {
        return eventReport;
    }
}
