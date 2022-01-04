package cz.fel.cvut.omo.fraloilyMaksidan.reports;

import cz.fel.cvut.omo.fraloilyMaksidan.reports.reportTransactions.EventTransaction;
import cz.fel.cvut.omo.fraloilyMaksidan.sensors.observer.EventManager;
import cz.fel.cvut.omo.fraloilyMaksidan.sensors.observer.Subscriber;

import java.util.*;
import java.util.stream.Collectors;

public class EventReport {
  final List<EventTransaction> reports = new ArrayList<>();

  public void addToReports(EventManager manager, String event, List<Subscriber> users) {
    users.forEach(user -> reports.add(new EventTransaction(manager, event, user)));
  }

  public Map<EventManager, Map<String, Long>> eventsBySource() {
    return reports.stream()
        .collect(
            Collectors.groupingBy(
                EventTransaction::getManager,
                Collectors.groupingBy(EventTransaction::getEvent, Collectors.counting())));
  }

  public Map<String, Map<Subscriber, Long>> eventsByEventOnly() {
    return reports.stream()
        .collect(
            Collectors.groupingBy(
                EventTransaction::getEvent,
                Collectors.groupingBy(EventTransaction::getUser, Collectors.counting())));
  }

}
