package cz.fel.cvut.omo.fraloilyMaksidan.sensors;

import cz.fel.cvut.omo.fraloilyMaksidan.Context;

import java.util.*;

public abstract class EventManager {
    Context context = Context.getInstance();
    Map<String, List<Subscriber>> subscribers = new HashMap<>();

    public EventManager(String... operations) {
        for(String operation : operations) {
            this.subscribers.put(operation, new ArrayList<>());
        }
    }

    public Map<String, List<Subscriber>> getSubscribers() {
        return subscribers;
    }

    public void subscribe(String eventType, Subscriber s) {
        List<Subscriber> users = subscribers.get(eventType);
        users.add(s);
    }

    public void notifySubscribers(String event) {
        List<Subscriber> users = subscribers.get(event);
        context.getReports().getEventReport().addToReports(this, event, users);
        for(Subscriber s: users) {
            s.update(event);
        }
    }
}
