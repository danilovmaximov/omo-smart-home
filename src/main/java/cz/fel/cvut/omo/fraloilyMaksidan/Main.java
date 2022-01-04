package cz.fel.cvut.omo.fraloilyMaksidan;


import cz.fel.cvut.omo.fraloilyMaksidan.activities.Activity;
import cz.fel.cvut.omo.fraloilyMaksidan.entities.LivingEntity;
import cz.fel.cvut.omo.fraloilyMaksidan.house.*;
import cz.fel.cvut.omo.fraloilyMaksidan.house.floor.Floor;
import cz.fel.cvut.omo.fraloilyMaksidan.house.room.Room;
import cz.fel.cvut.omo.fraloilyMaksidan.parsing.models.HouseModel;
import cz.fel.cvut.omo.fraloilyMaksidan.parsing.Loader;
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

    HouseModel houseModel = Loader.loadFromJSON("testConfig.json");
    Configurator.createFloorsFromJSON(houseModel.getFloors());
    Configurator.createHouseFromJSON(houseModel);
    Configurator.createActivitiesFromJSON(houseModel.getActivities());
    Configurator.createEntitiesFromJSON(houseModel.getEntities());
    Configurator.createStandardSensors();

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

    /*
       World Class is a wrapper around house class to provide different simulations...
    */
    World w1 = new World(MapContext.getHouse());
    w1.startSimulation(100);

    /*
       Reports are used to deliver different info based on the demand;
    */

    System.out.println("=========================== Reports =========================== ");
    reports.allReportsPrint(true);
    reports.allReportsPrintToFile("reports.txt");
    System.out.println("=========================== Reports =========================== ");
  }
}
