package cz.fel.cvut.omo.fraloilyMaksidan.activities;

import cz.fel.cvut.omo.fraloilyMaksidan.enums.Durability;
import cz.fel.cvut.omo.fraloilyMaksidan.reports.reportTransactions.ConsumptionTransaction;

public class ConsumingActivity extends Activity {

    protected final int electricityActive;
    protected final int gasActive;
    protected final int waterActive;
    protected final int electricityIdle;
    protected final int gasIdle;
    protected final int waterIdle;

    protected ConsumptionTransaction currentTransaction;

    public ConsumingActivity(String name, int activityLength, Durability durability,
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



}
