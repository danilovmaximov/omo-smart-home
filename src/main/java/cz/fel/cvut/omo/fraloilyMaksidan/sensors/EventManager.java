package cz.fel.cvut.omo.fraloilyMaksidan.sensors;

import cz.fel.cvut.omo.fraloilyMaksidan.Context;

import java.util.*;

public class EventManager {
    Map<String, List<Subscriber>> subscribers = new HashMap<>();

    public EventManager(String... operations) {
        for(String operation : operations) {
            this.subscribers.put(operation, new ArrayList<>());
        }
    }

    public Map<String, List<Subscriber>> getSubscribers() {
        return subscribers;
    }

    public void subscribe(String eventType, Subscriber... subs) {
        List<Subscriber> users = subscribers.get(eventType);
        Arrays.stream(subs)
                .forEach(sub -> users.add(sub));
    }

    public void notifySubscribers(String event) {
        List<Subscriber> users = subscribers.get(event);
        Context.getReports().getEventReport().addToReports(this, event, users);
        for(Subscriber s: users) {
            s.update(event);
        }
    }
}
