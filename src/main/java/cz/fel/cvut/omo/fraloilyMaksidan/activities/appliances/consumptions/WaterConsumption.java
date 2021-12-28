package cz.fel.cvut.omo.fraloilyMaksidan.activities.appliances.consumptions;

import cz.fel.cvut.omo.fraloilyMaksidan.enums.ConsumptionType;

public class WaterConsumption extends Consumption{

    public WaterConsumption(int perStep) {
        super(ConsumptionType.WATER, perStep);
    }
}
