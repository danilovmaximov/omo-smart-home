package cz.fel.cvut.omo.fraloilyMaksidan.senzors;

import cz.fel.cvut.omo.fraloilyMaksidan.Context;
import cz.fel.cvut.omo.fraloilyMaksidan.Iterable;

import java.util.*;

public abstract class EventManager implements Iterable {
    Context context = Context.getInstance();
    List<Subscriber> subscribers = new LinkedList<>();

    public EventManager(Subscriber... subscribers) {
        Collections.addAll(this.subscribers, subscribers);
    }

    public void subscribe(Subscriber s) {
        this.subscribers.add(s);
    }

    public void unsubscribe(Subscriber s) {
        this.subscribers.remove(s);
    }

    public void notifySubscribers() {
        for(Subscriber s: this.subscribers) {
            s.update();
        }
    }

}
