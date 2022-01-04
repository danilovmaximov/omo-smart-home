package cz.fel.cvut.omo.fraloilyMaksidan.reports.reportTransactions;

import cz.fel.cvut.omo.fraloilyMaksidan.sensors.observer.EventManager;
import cz.fel.cvut.omo.fraloilyMaksidan.sensors.observer.Subscriber;

/**
 * Used in reports to transfer information from an entity.
 */
public class EventTransaction {
  private final EventManager manager;
  private final String event;
  private final Subscriber user;

  public EventTransaction(EventManager manager, String event, Subscriber user) {
    this.manager = manager;
    this.event = event;
    this.user = user;
  }

  public EventManager getManager() {
    return manager;
  }

  public String getEvent() {
    return event;
  }

  public Subscriber getUser() {
    return user;
  }
}
