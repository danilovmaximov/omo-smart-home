package cz.fel.cvut.omo.fraloilyMaksidan.entities.activities.appliances.consumptions;

import cz.fel.cvut.omo.fraloilyMaksidan.entities.enums.ConsumptionType;

public class ElectricityConsumption extends Consumption{
    public ElectricityConsumption(int perStep) {
        super(ConsumptionType.ELECTRICITY, perStep);
    }
}
