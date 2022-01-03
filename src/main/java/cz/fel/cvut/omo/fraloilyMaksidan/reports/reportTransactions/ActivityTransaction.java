package cz.fel.cvut.omo.fraloilyMaksidan.reports.reportTransactions;

import cz.fel.cvut.omo.fraloilyMaksidan.entities.LivingEntity;

/**
 * Used in reports to transfer information from an entity.
 */
public class ActivityTransaction {
    private final LivingEntity entity;
    private final String activity;
    private String status;
    private int length;

    public ActivityTransaction(LivingEntity entity, String activity, String status, int length) {
        this.entity = entity;
        this.activity = activity;
        this.status = status;
        this.length = length;
    }

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
