package cz.fel.cvut.omo.fraloilyMaksidan.reports.reportTransactions;

import cz.fel.cvut.omo.fraloilyMaksidan.entities.LivingEntity;

/**
 * Used in reports to transfer information from an entity.
 */
public record ActivityTransaction(LivingEntity entity,
                                  String activity, String status, int length) {

    public int getLength() {
        return length;
    }

    public LivingEntity getEntity() {
        return entity;
    }

    public String getActivity() {
        return activity;
    }

    public String getStatus() {
        return status;
    }


}
