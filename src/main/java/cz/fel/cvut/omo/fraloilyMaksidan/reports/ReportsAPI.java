package cz.fel.cvut.omo.fraloilyMaksidan.reports;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReportsAPI {
  private Reports reports;

  public ReportsAPI(Reports reports) {
    this.reports = reports;
  }

  public void consumptionReportAmountPrint(boolean withBorders) {
    String border = withBorders ?
        "=================== Consumption report (amount) ===================" : "";
    printAsJSON(border, reports.getConsumptionReport().getAllConsumptions(1, 1, 1));
  }

  public void consumptionReportPricePrint(boolean withBorders, int gas, int water, int electricity) {
    String border = withBorders ?
        "=================== Consumption report (price) ===================" : "";
    printAsJSON(border, reports.getConsumptionReport().getAllConsumptions(gas,water,electricity));
  }

  public void eventReportPrint(boolean withBorders) {
    String border = withBorders ? "=================== Events report  ===================" : "";
    printAsJSON(border, reports.getEventReport().eventsBySource());
  }

  public void activityReportTotalStepsPrint(boolean withBorders) {
      String border = withBorders ?
          "=================== Activity report (Steps per activity) ===================" : "";
      printAsJSON(border, reports.getActivityReporter().EntityToActivityStepsMapping());
  }

  public void activityReportNumberOfUsagePrint(boolean withBorders) {
    String border = withBorders ?
        "=================== Activity report (Number of usage) ===================" : "";
    printAsJSON(border, reports.getActivityReporter().EntityToActivityNumberMapping());
  }

  public void configurationReportPrint(boolean withBorders) {
    String border = withBorders ?
        "=================== House configuration ===================" : "";
    System.out.println(reports.getHouseConfigurationReport().getConfiguration());
  }

  public void allReportsPrint(boolean withBorder) {
    consumptionReportPricePrint(withBorder, 2, 2, 2);
    consumptionReportAmountPrint(withBorder);
    eventReportPrint(withBorder);
    activityReportTotalStepsPrint(withBorder);
    activityReportNumberOfUsagePrint(withBorder);
    configurationReportPrint(withBorder);
  }

  private void printAsJSON(String border, Object toPrint) {
    System.out.println(border);
    try {
      System.out.println(
          new ObjectMapper()
              .writerWithDefaultPrettyPrinter()
              .writeValueAsString(toPrint)
      );
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    System.out.println(border);
  }
}
