package cz.fel.cvut.omo.fraloilyMaksidan.reports;

import cz.fel.cvut.omo.fraloilyMaksidan.reports.reportTransactions.EventTransaction;
import cz.fel.cvut.omo.fraloilyMaksidan.senzors.EventManager;
import cz.fel.cvut.omo.fraloilyMaksidan.senzors.Subscriber;

import java.util.*;
import java.util.stream.Collectors;

public class EventReport {
    List<EventTransaction> reports = new ArrayList<>();

    public void addToReports(EventManager manager, String event, List<Subscriber> users) {
        users.forEach( user -> reports.add(new EventTransaction(manager, event, user)));
    }

    public void eventsBySource() {
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
    }

    public void eventsByType() {

    }


}
