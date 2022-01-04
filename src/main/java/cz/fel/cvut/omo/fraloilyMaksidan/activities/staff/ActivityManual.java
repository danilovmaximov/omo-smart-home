package cz.fel.cvut.omo.fraloilyMaksidan.activities.staff;

@SuppressWarnings("ClassCanBeRecord")
public class ActivityManual {
    private final boolean isRepairable;

    public ActivityManual(boolean isRepairable) {
        this.isRepairable = isRepairable;
    }

    public boolean findOutIfRepairable() {
        return this.isRepairable;
    }
}