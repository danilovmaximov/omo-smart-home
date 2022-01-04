package cz.fel.cvut.omo.fraloilyMaksidan.reports.reportTransactions;

import cz.fel.cvut.omo.fraloilyMaksidan.sensors.observer.EventManager;
import cz.fel.cvut.omo.fraloilyMaksidan.sensors.observer.Subscriber;

/**
 * Used in reports to transfer information from an entity.
 */
public record EventTransaction(
    EventManager manager, String event,
    Subscriber user) {

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
