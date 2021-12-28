package cz.fel.cvut.omo.fraloilyMaksidan.activities.appliances.consumptions;

import cz.fel.cvut.omo.fraloilyMaksidan.entities.enums.ConsumptionType;

public class Consumption {
    private ConsumptionType type;
    private int perStep;

    public Consumption(ConsumptionType type, int perStep) {
        this.type = type;
        this.perStep = perStep;
    }

    public ConsumptionType getType() {
        return type;
    }

    public int getPerStep() {
        return perStep;
    }
}
