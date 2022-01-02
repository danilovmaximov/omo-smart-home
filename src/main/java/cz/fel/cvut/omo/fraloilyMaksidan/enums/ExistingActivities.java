package cz.fel.cvut.omo.fraloilyMaksidan.enums;

public enum ExistingActivities {
    COFFEE_MAKER("CoffeeMaker3000"),
    COMPUTER("Computer"),
    ELECTRIC_BIKE("Electric bike"),
    TV("TV"),
    COUCH("Couch"),
    REPAIR_KIT("Repair kit"),
    PLAY("Play"),
    SLEEP("Sleep"),
    REMEMBER("Remember old times"),
    BOILER("Boiler");

    private String name;
    ExistingActivities(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
}
