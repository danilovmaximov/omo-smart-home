package cz.fel.cvut.omo.fraloilyMaksidan.entities;

import cz.fel.cvut.omo.fraloilyMaksidan.activities.Activity;
import cz.fel.cvut.omo.fraloilyMaksidan.sensors.observer.Subscriber;

import java.util.*;

public class Grandmother extends LivingEntity implements Subscriber {
    final List<Cat> cats = new ArrayList<>();

    public Grandmother(String name, List<Activity> activities) {
        super(name, activities);
    }

    public void addCats(Cat... cats) {
        Collections.addAll(this.cats, cats);
        Arrays.stream(cats).forEach(cat -> cat.addCleaner(this));
    }

    @Override
    public void update(String event) {
        var pissedCat = cats.stream()
                .filter(cat -> Objects.equals(event, cat.getName()))
                .toList().get(0);
        this.addEmergentActivity(pissedCat.getGeneratedActivity());
    }
}
