package cz.fel.cvut.omo.fraloilyMaksidan.reports;

import cz.fel.cvut.omo.fraloilyMaksidan.senzors.EventManager;
import cz.fel.cvut.omo.fraloilyMaksidan.senzors.Subscriber;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class EventReport {
    Map<EventManager, Map<String, Subscriber>> reports = new LinkedHashMap<>();

    public void addToReports(EventManager em, String event, List<Subscriber> users) {
        reports.entrySet().stream();
    }
}
