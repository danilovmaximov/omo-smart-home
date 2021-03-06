package cz.fel.cvut.omo.fraloilyMaksidan.entities;
import cz.fel.cvut.omo.fraloilyMaksidan.activities.Activity;
import cz.fel.cvut.omo.fraloilyMaksidan.sensors.observer.Subscriber;

import java.util.*;

public class Mother extends LivingEntity implements Subscriber {
    private final List<Baby> babies = new ArrayList<>();

    public Mother(String name, List<Activity> activities) {
        super(name, activities);
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
