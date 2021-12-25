package cz.fel.cvut.omo.fraloilyMaksidan.entities.activities.appliances.consumptions;

import cz.fel.cvut.omo.fraloilyMaksidan.entities.enums.ConsumptionType;

public class WaterConsumption extends Consumption{

    public WaterConsumption(int perStep) {
        super(ConsumptionType.WATER, perStep);
    }
}
