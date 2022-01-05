package cz.fel.cvut.omo.fraloilyMaksidan;

import cz.fel.cvut.omo.fraloilyMaksidan.reports.ReportsAPI;
import cz.fel.cvut.omo.fraloilyMaksidan.strategy.RainyDayStrategy;

public class Main {
  public static void main(String[] args) {

    /*
       Configure context of application:
       Weather events, report classes...
    */
    Context.setSun(false);
    Context.setHumidityLevel(65);
    Context.setOxygenLevel(70);
    Context.setTempLevel(20);
    Context.setCurrentStrategy(new RainyDayStrategy());
    ReportsAPI reports = new ReportsAPI(Context.getReports());

    /*  Configuration is loaded from JSON. and main driver is returned */
    World w1 = Configurator.loadHouseFromConfig("firstConfig.json");
    w1.startSimulation(300);

    /* Reports are used to deliver different info based on the demand. Can be printed to file or terminal. */
    System.out.println("=========================== Reports =========================== ");
    reports.allReportsPrint(true);
    reports.allReportsPrintToFile("reports.txt");
  }
}
