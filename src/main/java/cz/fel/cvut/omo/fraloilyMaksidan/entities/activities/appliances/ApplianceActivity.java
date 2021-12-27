package cz.fel.cvut.omo.fraloilyMaksidan.entities.activities.appliances;

import cz.fel.cvut.omo.fraloilyMaksidan.entities.LivingEntity;
import cz.fel.cvut.omo.fraloilyMaksidan.entities.activities.appliances.consumptions.Consumption;
import cz.fel.cvut.omo.fraloilyMaksidan.entities.activities.staff.Activity;
import cz.fel.cvut.omo.fraloilyMaksidan.entities.enums.Durability;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public abstract class ApplianceActivity extends Activity implements Comparable<ApplianceActivity> {
    private List<Consumption> consumptionTypes = new ArrayList<>();

    public ApplianceActivity(String name, int activityLength, Durability durability, Consumption... consumptions) {
        super(name, activityLength, durability);
        Collections.addAll(consumptionTypes, consumptions);
    }

    @Override
    protected void manageStep() {
        super.manageStep();
        context.getReports()
                .getConsumptionReport()
                .addConsumption(this, consumptionTypes);
    }

    @Override
    public int compareTo(ApplianceActivity o) {
        return this.toString().compareTo(o.toString());
    }
}