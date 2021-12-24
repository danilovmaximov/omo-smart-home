package cz.fel.cvut.omo.fraloilyMaksidan.reports;


import cz.fel.cvut.omo.fraloilyMaksidan.entities.LivingEntity;
import cz.fel.cvut.omo.fraloilyMaksidan.entities.activities.Activity;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ActivityReporter {
    Map<LivingEntity, Activity> reports = new HashMap<>();

    public void addToReports(LivingEntity entity, Activity activity) {
        reports.put(entity, activity);
    }

    public void EntityToActivityMapping() {
        reports.entrySet()
                .stream()
                .forEach( (entry) -> System.out.println(entry.getKey() + " used " + entry.getValue()));
    }


    public void EntityToActivityNumberMapping() {
        //TODO: Smart way of doing "kolikrát které osoby použily které zařízení."
        reports.entrySet()
                .stream()
                .sorted()
                .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.counting()))
                .forEach((entity, aLong) -> System.out.println());
    }
}
