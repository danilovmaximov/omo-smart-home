package cz.fel.cvut.omo.fraloilyMaksidan.reports;

import cz.fel.cvut.omo.fraloilyMaksidan.activities.ConsumingActivity;

import cz.fel.cvut.omo.fraloilyMaksidan.reports.reportTransactions.ConsumptionModel;
import cz.fel.cvut.omo.fraloilyMaksidan.reports.reportTransactions.ConsumptionTransaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConsumptionReport {

  final List<ConsumptionTransaction> reports = new ArrayList<>();

  public void addTransaction(ConsumptionTransaction transaction) {
    reports.add(transaction);
  }

  //  ugly, but works, cannot do Collectors.reduce()
  public Map<ConsumingActivity, ConsumptionModel> getAllConsumptions(int g, int w, int e) {
    var newmap = new HashMap<ConsumingActivity, ConsumptionModel>();
    reports.stream()
        .collect(Collectors.groupingBy(ConsumptionTransaction::getActivity))
        .forEach(
            ((activity, transactions) -> {
              var model = new ConsumptionModel(0, 0, 0);
              for (ConsumptionTransaction t : transactions) {
                model.electricity += t.getElectricity() * e;
                model.gas += t.getGas() * g;
                model.water += t.getWater() * w;
              }
              newmap.put(activity, model);
            }));
    return newmap;
  }
}

/*
Collectors.reducing(
                    new ConsumptionModel(0, 0, 0),
                    t -> new ConsumptionModel(t.getWater(), t.getGas(), t.getElectricity()),
                    (prev, next) -> {
                      prev.electricity += next.electricity;
                      prev.gas += next.gas;
                      prev.water += next.water;
                      return prev;
                    })*/
