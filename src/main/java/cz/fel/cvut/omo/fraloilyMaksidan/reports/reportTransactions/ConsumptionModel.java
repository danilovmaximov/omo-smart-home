package cz.fel.cvut.omo.fraloilyMaksidan.reports.reportTransactions;

/**
 * Used in reports coz I am dumb.
 */
@SuppressWarnings("GrazieInspection")
public class ConsumptionModel {
  public int water;
  public int gas;
  public int electricity;

  public ConsumptionModel(int water, int gas, int electricity) {
    this.water = water;
    this.gas = gas;
    this.electricity = electricity;
  }
}
