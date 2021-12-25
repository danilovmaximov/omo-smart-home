package cz.fel.cvut.omo.fraloilyMaksidan.senzors;

import cz.fel.cvut.omo.fraloilyMaksidan.Context;
import cz.fel.cvut.omo.fraloilyMaksidan.Iterable;

import java.util.*;

public abstract class EventManager implements Iterable {
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

    abstract public void step();
}
