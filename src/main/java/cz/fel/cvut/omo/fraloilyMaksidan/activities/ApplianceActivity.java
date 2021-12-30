package cz.fel.cvut.omo.fraloilyMaksidan.activities;

import cz.fel.cvut.omo.fraloilyMaksidan.entities.LivingEntity;
import cz.fel.cvut.omo.fraloilyMaksidan.enums.Durability;
import cz.fel.cvut.omo.fraloilyMaksidan.reports.reportTransactions.ConsumptionTransaction;

public abstract class ApplianceActivity extends Activity {

    private boolean isActive = false;

    private final int electricityActive;
    private final int gasActive;
    private final int waterActive;
    private final int electricityIdle;
    private final int gasIdle;
    private final int waterIdle;

    private ConsumptionTransaction currentTransaction;

    public ApplianceActivity(String name, int activityLength, Durability durability,
                             int electricityActive, int gasActive, int waterActive,
                             int electricityIdle, int gasIdle, int waterIdle) {
        super(name, activityLength, durability);
        this.electricityActive = electricityActive;
        this.gasActive = gasActive;
        this.waterActive = waterActive;
        this.electricityIdle = electricityIdle;
        this.gasIdle = gasIdle;
        this.waterIdle = waterIdle;
    }

    public boolean isActive() {
        return isActive;
    }

    public void toggleActivity() {
        isActive = isActive == true ? false : true;
    }

    @Override
    protected void manageIdle() {
        super.manageIdle();
        currentTransaction = new ConsumptionTransaction(this,
                electricityIdle, gasIdle, waterIdle);
    }

    @Override
    protected void useActivityBy(LivingEntity entity) {
        super.useActivityBy(entity);
        toggleActivity();
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