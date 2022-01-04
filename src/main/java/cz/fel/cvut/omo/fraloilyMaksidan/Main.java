package cz.fel.cvut.omo.fraloilyMaksidan;


import cz.fel.cvut.omo.fraloilyMaksidan.activities.Activity;
import cz.fel.cvut.omo.fraloilyMaksidan.entities.LivingEntity;
import cz.fel.cvut.omo.fraloilyMaksidan.house.*;
import cz.fel.cvut.omo.fraloilyMaksidan.house.floor.Floor;
import cz.fel.cvut.omo.fraloilyMaksidan.house.room.Room;
import cz.fel.cvut.omo.fraloilyMaksidan.reports.ReportsAPI;

public class Main {
  public static void main(String[] args) {

    /*
       Configure context of application:
       Weather events, report classes...
    */
    Context.setSun(true);
    Context.setHumidityLevel(65);
    Context.setOxygenLevel(70);
    Context.setTempLevel(20);
    ReportsAPI reports = new ReportsAPI(Context.getReports());

    /*  Configuration is loaded from JSON. and main driver is returned */
    World w1 = Configurator.loadHouseFromConfig("testConfig.json");

    System.out.println("Floors: ");
    for (Floor floor : MapContext.getFloorsInHouse().values().stream().toList()) {
      System.out.println("   " + floor);
    }

    System.out.println("Rooms: ");
    for (Room room : MapContext.getRoomsInHouse().values().stream().toList()) {
      System.out.println("   " + room);
    }

    System.out.println("Activities: ");
    for (Activity activity : MapContext.getActivitiesInHouse().values().stream().toList()) {
      System.out.println("   " + activity);
    }

    System.out.println("Entities: ");
    for (LivingEntity entity : MapContext.getEntitiesInHouse().values().stream().toList()) {
      System.out.println("   " + entity);
    }

    w1.startSimulation(100);

    /* Reports are used to deliver different info based on the demand. Can be printed to file or terminal. */

    System.out.println("=========================== Reports =========================== ");
    reports.allReportsPrint(true);
    reports.allReportsPrintToFile("reports.txt");
  }
}
