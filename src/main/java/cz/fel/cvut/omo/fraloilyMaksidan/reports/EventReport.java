package cz.fel.cvut.omo.fraloilyMaksidan.reports;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cz.fel.cvut.omo.fraloilyMaksidan.reports.reportTransactions.EventTransaction;
import cz.fel.cvut.omo.fraloilyMaksidan.sensors.EventManager;
import cz.fel.cvut.omo.fraloilyMaksidan.sensors.Subscriber;

import java.util.*;
import java.util.stream.Collectors;

public class EventReport {
  List<EventTransaction> reports = new ArrayList<>();

  public void addToReports(EventManager manager, String event, List<Subscriber> users) {
    users.forEach(user -> reports.add(new EventTransaction(manager, event, user)));
  }

  public Map<EventManager, Map<String, Long>> eventsBySource() {
    return reports.stream()
        .collect(
            Collectors.groupingBy(
                EventTransaction::getManager,
                Collectors.groupingBy(EventTransaction::getEvent, Collectors.counting())));
    /*
    //TODO: Make smarter.
    var users = reports.stream()
            .collect(Collectors.groupingBy(EventTransaction::getManager));
    users.forEach((Manager, transactions) -> {
        System.out.println("Source " + Manager + ":");
        transactions.stream()
                .collect(Collectors.groupingBy(EventTransaction::getEvent))
                .forEach((event, mapped) -> {
                    System.out.print("  Event " + event + " send to: [ ");
                    mapped.forEach(entry -> System.out.print(entry.getUser() + " "));
                    System.out.println("]");
                });
    });

     */
  }

  public Map<String, Map<Subscriber, Long>> eventsByEventOnly() {
    return reports.stream()
        .collect(
            Collectors.groupingBy(
                EventTransaction::getEvent,
                Collectors.groupingBy(EventTransaction::getUser, Collectors.counting())));
  }

  public void eventsByTargetOnly() {}

}
