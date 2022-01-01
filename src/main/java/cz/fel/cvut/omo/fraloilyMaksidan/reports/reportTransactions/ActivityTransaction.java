package cz.fel.cvut.omo.fraloilyMaksidan.reports.reportTransactions;

import cz.fel.cvut.omo.fraloilyMaksidan.activities.Activity;
import cz.fel.cvut.omo.fraloilyMaksidan.entities.LivingEntity;

public class ActivityTransaction {
    private final LivingEntity entity;
    private final String activity;
    private String status;

    public ActivityTransaction(LivingEntity entity, String activity, String status) {
        this.entity = entity;
        this.activity = activity;
        this.status = status;
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
