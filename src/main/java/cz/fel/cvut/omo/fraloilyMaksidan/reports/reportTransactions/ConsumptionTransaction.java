package cz.fel.cvut.omo.fraloilyMaksidan.reports.reportTransactions;

import cz.fel.cvut.omo.fraloilyMaksidan.activities.ApplianceActivity;

public class ConsumptionTransaction {
    private ApplianceActivity entity;
    private int electricity;
    private int gas;
    private int water;

    public ConsumptionTransaction(ApplianceActivity entity, int electricity, int gas, int water) {
        this.entity = entity;
        this.electricity = electricity;
        this.gas = gas;
        this.water = water;
    }

    public ApplianceActivity getEntity() {
        return entity;
    }

    public int getElectricity() {
        return electricity;
    }

    public int getGas() {
        return gas;
    }

    public int getWater() {
        return water;
    }
}
