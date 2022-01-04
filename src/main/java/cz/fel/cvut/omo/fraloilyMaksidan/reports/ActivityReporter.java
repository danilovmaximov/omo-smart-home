package cz.fel.cvut.omo.fraloilyMaksidan.reports;

import cz.fel.cvut.omo.fraloilyMaksidan.entities.LivingEntity;
import cz.fel.cvut.omo.fraloilyMaksidan.reports.reportTransactions.ActivityTransaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ActivityReporter {

  final List<ActivityTransaction> transactions = new ArrayList<>();

  public void addToReports(LivingEntity entity, String activity, String status, int length) {
    transactions.add(new ActivityTransaction(entity, activity, status, length));
  }

  public Map<LivingEntity, Map<String, Integer>> EntityToActivityStepsMapping() {
    return transactions.stream()
        .collect(
            Collectors.groupingBy(
                ActivityTransaction::getEntity,
                Collectors.groupingBy(
                    ActivityTransaction::getActivity,
                    Collectors.reducing(0, ActivityTransaction::getLength, Integer::sum))));
  }

  public Map<LivingEntity, Map<String, Long>> EntityToActivityNumberMapping() {
    return transactions.stream()
        .collect(
            Collectors.groupingBy(
                ActivityTransaction::getEntity,
                Collectors.groupingBy(ActivityTransaction::getActivity, Collectors.counting())));
  }
}
