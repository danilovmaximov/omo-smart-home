package cz.fel.cvut.omo.fraloilyMaksidan.activities.appliances;


import cz.fel.cvut.omo.fraloilyMaksidan.activities.ConsumingActivity;
import cz.fel.cvut.omo.fraloilyMaksidan.enums.Durability;
import cz.fel.cvut.omo.fraloilyMaksidan.reports.reportTransactions.ConsumptionTransaction;

public abstract class ApplianceActivity extends ConsumingActivity {


    public ApplianceActivity(String name, int activityLength, Durability durability,
                             int electricityActive, int gasActive, int waterActive,
                             int electricityIdle, int gasIdle, int waterIdle) {
        super(name, activityLength, durability, electricityActive, gasActive, waterActive, electricityIdle, gasIdle, waterIdle);
    }

    @Override
    protected void manageIdle() {
        super.manageIdle();
        currentTransaction = new ConsumptionTransaction(this,
                electricityIdle, gasIdle, waterIdle);
    }


    @Override
    protected void manageStep() {
        super.manageStep();
        currentTransaction = new ConsumptionTransaction(this,
                electricityActive, gasActive, waterActive);
    }

    public ConsumptionTransaction getCurrentTransaction() {
        return currentTransaction;
    }
}