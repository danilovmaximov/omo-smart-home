package cz.fel.cvut.omo.fraloilyMaksidan.enums;

public enum ExistingActivities {
    COFFEE_MAKER("CoffeeMaker3000"),
    COMPUTER("Computer"),
    ELECTRIC_BIKE("Electric bike"),
    TV("TV"),
    COUCH("Couch"),
    REPAIR_KIT("Repair kit"),
    BOILER("Boiler"),
    PLAY("Play"),
    SLEEP("Sleep"),
    REMEMBER("Remember good times"),
    BLOOP("Bloop"),
    DRIP("Drip"),
    SPLASH("Splash"),
    JUMP_AROUND("Jump around"),
    HUM("Hum"),
    WASH("Wash"),
    CLEAN_UP("Clean up"),
    PLAY_BALL("Play ball"),
    CHASE("Chase the tail"),
    SKIS("Skis"),
    TREADMILL("Treadmill"),
    KITCHEN_STOVE("Kitchen stove"),
    AUDIO_SYSTEM("Audio system"),
    WASHING_MACHINE("Washing machine"),
    CAR("Car"),
    BARK("Bark");

    private final String name;
    ExistingActivities(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
}
