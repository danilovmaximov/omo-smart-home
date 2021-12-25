package cz.fel.cvut.omo.fraloilyMaksidan.reports;

import cz.fel.cvut.omo.fraloilyMaksidan.senzors.EventManager;
import cz.fel.cvut.omo.fraloilyMaksidan.senzors.Subscriber;

import java.util.*;
import java.util.stream.Collectors;

public class EventReport {
    Map<EventManager, Map<String, List<Subscriber>>> reports = new LinkedHashMap<>();

    public void addToReports(EventManager em, String event, List<Subscriber> users) {
        if(reports.containsKey(em)) {
            var entry = reports.get(em);
            if(entry.containsKey(event)) {
                var subscriberList = entry.get(event);
                subscriberList.addAll(users);
            } else {
                entry.put(event, users);
            }
        } else {
            Map<String, List<Subscriber>> value = new HashMap<>();
            value.put(event, users);
            reports.put(em, value);
        }
    }

    public void eventsBySource() {
        reports.entrySet().stream()
                .sorted()
                .forEach(entry -> {
                    EventManager manager = entry.getKey();
                    System.out.println(manager + " sends signals to: ");
                    entry.getValue().entrySet().stream()
                        .forEach(entry2 -> System.out.println(entry2.getKey() + Arrays.toString(entry2.getValue().toArray())));
                });
    }

    public void eventsByType() {

    }


}
