package cz.fel.cvut.omo.fraloilyMaksidan.entities.activities.staff;

public record ActivityManual(boolean isRepairable) {
    public boolean findOutIfRepairable() {
        return this.isRepairable;
    }
}