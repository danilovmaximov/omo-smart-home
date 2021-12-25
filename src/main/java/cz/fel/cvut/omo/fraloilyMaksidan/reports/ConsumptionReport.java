package cz.fel.cvut.omo.fraloilyMaksidan.reports;

import cz.fel.cvut.omo.fraloilyMaksidan.entities.activities.appliances.ApplianceActivity;
import cz.fel.cvut.omo.fraloilyMaksidan.entities.activities.appliances.consumptions.Consumption;
import cz.fel.cvut.omo.fraloilyMaksidan.entities.enums.ConsumptionType;
import cz.fel.cvut.omo.fraloilyMaksidan.reports.reportObjects.ConsumptionTransaction;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ConsumptionReport {
    private int gasPerUnitPrice = 10;
    private int waterPerUnitPrice = 15;
    private int electricityPerUnitPrice = 20;

    List<ConsumptionTransaction> reports = new ArrayList<>();

    public void setPricePerUnit(int gasPrice, int waterPrice, int electricityPrice) {
        this.electricityPerUnitPrice = electricityPrice;
        this.gasPerUnitPrice = gasPrice;
        this.waterPerUnitPrice = waterPrice;
    }

    public void addConsumption(ApplianceActivity entity, List<Consumption> consumptions) {
        consumptions.stream()
            .forEach(consumption -> reports.add(new ConsumptionTransaction(entity, consumption)));
    }

    public void getAllConsumptions() {
        reports.stream()
                .collect(Collectors.groupingBy(ConsumptionTransaction::getEntity))
                .forEach((entity, listOfConsumption) -> {
                    System.out.println(entity +":\n");
                    System.out.printf("Electricity consumption: %d\n", reducePriceByConsumption(listOfConsumption, ConsumptionType.ELECTRICITY));
                    System.out.printf("Water consumption: %d\n", reducePriceByConsumption(listOfConsumption, ConsumptionType.WATER));
                    System.out.printf("Gas consumption: %d\n", reducePriceByConsumption(listOfConsumption, ConsumptionType.GAS));
                });

    }

    private int reducePriceByConsumption(List<ConsumptionTransaction> listOfConsumption, ConsumptionType type) {
        return listOfConsumption.stream()
                .filter(consumptionTransaction -> consumptionTransaction.getConsumption().getType() == type)
                .map(consumptionTransaction -> consumptionTransaction.getConsumption())
                .reduce(0, (subtotal, cons) -> subtotal + cons.getPerStep(), Integer::sum);
    }

}
