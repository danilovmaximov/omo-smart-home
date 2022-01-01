package cz.fel.cvut.omo.fraloilyMaksidan.reports;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cz.fel.cvut.omo.fraloilyMaksidan.entities.LivingEntity;
import cz.fel.cvut.omo.fraloilyMaksidan.reports.reportTransactions.ActivityTransaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ActivityReporter {

    List<ActivityTransaction> transactions = new ArrayList<>();

    public void addToReports(LivingEntity entity, String activity, String status) {
        transactions.add(new ActivityTransaction(entity, activity, status));
    }

    private Map<LivingEntity, Map<String, Long>> EntityToActivityMapping() {
        return transactions.stream()
                .collect(Collectors.groupingBy(
                                ActivityTransaction::getEntity, Collectors.groupingBy(
                                        ActivityTransaction::getActivity, Collectors.counting()
                                )
                ));
    }

    public void activityReportPrint(boolean withBorders) {
        String border = withBorders ?
                "=================== Activity report ===================" : "";
        System.out.println(border);
        try {
            System.out.println(
                    (new ObjectMapper()
                            .writerWithDefaultPrettyPrinter()
                            .writeValueAsString(EntityToActivityMapping()))
            );
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(border);
    }

    public void activityReportPrint(String file) {

    }
}
