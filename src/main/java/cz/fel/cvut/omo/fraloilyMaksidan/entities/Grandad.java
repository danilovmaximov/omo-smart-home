package cz.fel.cvut.omo.fraloilyMaksidan.entities;

import cz.fel.cvut.omo.fraloilyMaksidan.Configurator;
import cz.fel.cvut.omo.fraloilyMaksidan.activities.Activity;
import cz.fel.cvut.omo.fraloilyMaksidan.enums.ExistingActivities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Grandad extends LivingEntity {
    private static final List<ExistingActivities> standardActivities = new ArrayList<ExistingActivities>(
        Arrays.asList(ExistingActivities.COFFEE_MAKER, ExistingActivities.SLEEP,
            ExistingActivities.REPAIR_KIT, ExistingActivities.TV,
            ExistingActivities.REMEMBER)
    );
    public Grandad(String name) {
        super(name, standardActivities);
    }
}
