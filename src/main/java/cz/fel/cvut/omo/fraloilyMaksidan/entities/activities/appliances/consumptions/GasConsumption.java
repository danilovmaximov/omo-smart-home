package cz.fel.cvut.omo.fraloilyMaksidan.entities.activities.appliances.consumptions;

import cz.fel.cvut.omo.fraloilyMaksidan.entities.enums.ConsumptionType;

public class GasConsumption extends Consumption{
    public GasConsumption(int perStep) {
        super(ConsumptionType.GAS, perStep);
    }
}
