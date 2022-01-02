package cz.fel.cvut.omo.fraloilyMaksidan.entities;
import cz.fel.cvut.omo.fraloilyMaksidan.activities.Activity;
import cz.fel.cvut.omo.fraloilyMaksidan.enums.ExistingActivities;
import cz.fel.cvut.omo.fraloilyMaksidan.sensors.Subscriber;

import java.util.*;

public class Mom extends LivingEntity implements Subscriber {
    private final static List<ExistingActivities> standardActivities = new ArrayList<ExistingActivities>(
        Arrays.asList(ExistingActivities.ELECTRIC_BIKE, ExistingActivities.COFFEE_MAKER,
             ExistingActivities.ELECTRIC_BIKE, ExistingActivities.ELECTRIC_BIKE,
            ExistingActivities.COFFEE_MAKER, ExistingActivities.COUCH)
    );

    private final List<Baby>babies = new ArrayList<>();

    public Mom(String name) {
        super(name, standardActivities);
    }

    public void addBabies(Baby... babies) {
        Collections.addAll(this.babies, babies);
        Arrays.stream(babies).forEach(baby -> baby.addSupervisor(this));
    }

    public void update(String event) {
        var angryBaby = babies.stream()
                .filter(baby -> event.equals(baby.toString()))
                .toList().get(0);

        this.addEmergentActivity(angryBaby.getGeneratedActivity());
    }
}
