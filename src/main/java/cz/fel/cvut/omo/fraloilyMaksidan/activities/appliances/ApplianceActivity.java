package cz.fel.cvut.omo.fraloilyMaksidan.activities.appliances;

import cz.fel.cvut.omo.fraloilyMaksidan.Context;
import cz.fel.cvut.omo.fraloilyMaksidan.activities.appliances.consumptions.Consumption;
import cz.fel.cvut.omo.fraloilyMaksidan.activities.staff.Activity;
import cz.fel.cvut.omo.fraloilyMaksidan.enums.Durability;

import java.util.List;

public abstract class ApplianceActivity extends Activity {
    private final List<Consumption> consumptionTypesActive;
    private final List<Consumption> consumptionTypesIdle;

    public ApplianceActivity(String name, int activityLength, Durability durability, List<Consumption> active, List<Consumption> idle) {
        super(name, activityLength, durability);
        consumptionTypesActive = active;
        consumptionTypesIdle = idle;
    }

    @Override
    protected void manageStep() {
        super.manageStep();
        Context.getReports()
                .getConsumptionReport()
                .addConsumption(this, consumptionTypesActive);
    }

    @Override
    protected void manageIdle() {
        super.manageIdle();
        Context.getReports()
                .getConsumptionReport()
                .addConsumption(this, consumptionTypesIdle);
    }
}