package cz.fel.cvut.omo.fraloilyMaksidan.enums;

public enum Durability {
    UNBREAKABLE(0), STRONG(5), NORMAL(10), WEAK(20);

    private final int deter; // deterioration
    Durability(int det) {
        this.deter = det;
    }
    public int getDeterioration() {
        return this.deter;
    }
}
