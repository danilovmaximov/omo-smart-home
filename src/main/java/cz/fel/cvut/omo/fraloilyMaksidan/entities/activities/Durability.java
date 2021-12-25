package cz.fel.cvut.omo.fraloilyMaksidan.entities.activities;

enum Durability {
    UNBREAKABLE(0), STRONG(5), NORMAL(10), WEAK(20);

    private int deter; // deterioration
    Durability(int det) {
        this.deter = det;
    }
    public int getDeterioration() {
        return this.deter;
    }
}
