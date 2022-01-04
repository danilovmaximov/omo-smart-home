package cz.fel.cvut.omo.fraloilyMaksidan.reports;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;


/**
 * ReportsAPI used to get information about house configuration, events, resource consumption and
 * activities around the house.
 */

public record ReportsAPI(Reports reports) {

    private static String relative = "./src/main/resources/reports/";

    /**
     * @param newRelativePath Sets new relative path for writing file
     */
    public void setRelativePath(String newRelativePath) {
        relative = newRelativePath;
    }

    public String getRelativePath() {
        return relative;
    }

    /* ================= Print to terminal ================= */
    public void consumptionReportAmountPrint(boolean withBorders) {
        String border = withBorders ?
            "=================== Consumption report (amount) ===================" : "";
        printAsJSON(border, reports.getConsumptionReport().getAllConsumptions(1, 1, 1));
    }

    public void consumptionReportPricePrint(boolean withBorders, int gas, int water,
        int electricity) {
        String border = withBorders ?
            "=================== Consumption report (price) ===================" : "";
        printAsJSON(border, reports.getConsumptionReport().getAllConsumptions(gas, water, electricity));
    }

    public void eventReportPrint(boolean withBorders) {
        String border = withBorders ? "=================== Events report  ===================" : "";
        printAsJSON(border, reports.getEventReport().eventsBySource());
    }

    public void eventReportWithoutSourcePrint(boolean withBorders) {
        String border = withBorders ? "=================== Events report  ===================" : "";
        printAsJSON(border, reports.getEventReport().eventsByEventOnly());
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
        if (withBorders) {
            System.out.println(border);
        }
        System.out.println(reports.getHouseConfigurationReport().getConfiguration());
        if (withBorders) {
            System.out.println(border);
        }
    }

    /* ================= Print to the file ================= */
    public void consumptionReportAmountPrint(String filename) {
        printJSONtoFile(filename, reports.getConsumptionReport().getAllConsumptions(1, 1, 1));
    }

    public void consumptionReportPricePrint(String filename, int gas, int water, int electricity) {
        printJSONtoFile(filename,
            reports.getConsumptionReport().getAllConsumptions(gas, water, electricity));
    }

    public void eventReportPrint(String filename) {
        printJSONtoFile(filename, reports.getEventReport().eventsBySource());
    }

    public void eventReportWithoutSourcePrint(String filename) {
        printJSONtoFile(filename, reports.getEventReport().eventsByEventOnly());
    }

    public void activityReportTotalStepsPrint(String filename) {
        printJSONtoFile(filename, reports.getActivityReporter().EntityToActivityStepsMapping());
    }

    public void activityReportNumberOfUsagePrint(String filename) {
        printJSONtoFile(filename, reports.getActivityReporter().EntityToActivityNumberMapping());
    }

    public void configurationReportPrint(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(reports.getHouseConfigurationReport().getConfiguration().toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     * @param withBorder Calls every existing API method to print info to the terminal.
     */
    public void allReportsPrint(boolean withBorder) {
        consumptionReportPricePrint(withBorder, 2, 2, 2);
        consumptionReportAmountPrint(withBorder);
        eventReportPrint(withBorder);
        eventReportWithoutSourcePrint(withBorder);
        activityReportTotalStepsPrint(withBorder);
        activityReportNumberOfUsagePrint(withBorder);
        configurationReportPrint(withBorder);
    }


    /**
     * @param filename Calls every existing API method to print into to the given file.
     */
    public void allReportsPrintToFile(String filename) {
        consumptionReportPricePrint("ConsumptionPrice:" + filename, 2, 2, 2);
        consumptionReportAmountPrint("ConsumptionAmount:" + filename);
        eventReportPrint("eventsFull:" + filename);
        eventReportWithoutSourcePrint("eventsByEvents:" + filename);
        activityReportTotalStepsPrint("activitySteps:" + filename);
        activityReportNumberOfUsagePrint("activityNumberOfUsage:" + filename);
        configurationReportPrint("configurationHouse:" + filename);
    }


    /**
     * Uses Jackson dependancy.
     */
    private void printJSONtoFile(String filename, Object map) {
        try {
            (new ObjectMapper()).writerWithDefaultPrettyPrinter()
                .writeValue(Paths.get(ReportsAPI.relative + filename).toFile(), map);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Uses Jackson dependancy.
     */
    private void printAsJSON(String border, Object toPrint) {
        System.out.println(border);
        ObjectWriter writer = (new ObjectMapper()).writerWithDefaultPrettyPrinter();
        try {
            System.out.println(writer.writeValueAsString(toPrint));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(border);
    }
}
