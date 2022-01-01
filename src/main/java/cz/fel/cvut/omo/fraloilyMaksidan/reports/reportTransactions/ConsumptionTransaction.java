package cz.fel.cvut.omo.fraloilyMaksidan.reports.reportTransactions;

import cz.fel.cvut.omo.fraloilyMaksidan.activities.appliances.ApplianceActivity;

public class ConsumptionTransaction {
    private ApplianceActivity activity;
    private int electricity;
    private int gas;
    private int water;

    public ConsumptionTransaction(ApplianceActivity activity, int electricity, int gas, int water) {
        this.activity = activity;
        this.electricity = electricity;
        this.gas = gas;
        this.water = water;
    }

    public ApplianceActivity getActivity() {
        return activity;
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
