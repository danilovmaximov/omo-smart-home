package cz.fel.cvut.omo.fraloilyMaksidan;


import cz.fel.cvut.omo.fraloilyMaksidan.entities.Baby;
import cz.fel.cvut.omo.fraloilyMaksidan.entities.Father;
import cz.fel.cvut.omo.fraloilyMaksidan.entities.Grandad;
import cz.fel.cvut.omo.fraloilyMaksidan.entities.Mom;
import cz.fel.cvut.omo.fraloilyMaksidan.enums.ExistingActivities;
import cz.fel.cvut.omo.fraloilyMaksidan.house.*;
import cz.fel.cvut.omo.fraloilyMaksidan.reports.ReportsAPI;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
  private static ObjectMapper objectMapper = new ObjectMapper();

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

    /* Create activities for the house */
    Configurator.createActivityAll(
        ExistingActivities.COFFEE_MAKER, ExistingActivities.REPAIR_KIT,
        ExistingActivities.ELECTRIC_BIKE, ExistingActivities.COUCH,
        ExistingActivities.TV, ExistingActivities.BOILER);

    /* Create entities */
    var father = new Father("Van Darkholme");
    var grandad = new Grandad("Billy Herrington");
    var mom = new Mom("Dungeon master");
    var babyBoy = new Baby("Slave");
    mom.addBabies(babyBoy);

    Configurator.createStandardRooms();
    Configurator.setUnattachedActivitiesToRooms();
    Configurator.setEntitiesToRoom();
    Configurator.createStandardFloors();
    Configurator.createStandardSensors();
    Configurator.createStandardHouse();

    /*
       World Class is a wrapper around house class to provide different simulations...
    */
    World w1 = new World(MapContext.getHouse());
    w1.startSimulation(50);

    /*
       Reports are used to deliver different info based on the demand;
    */

    System.out.println("=========================== Reports =========================== ");
    reports.allReportsPrint(true);
    reports.allReportsPrintToFile("reports.txt");
    System.out.println("=========================== Reports =========================== ");
  }
}
