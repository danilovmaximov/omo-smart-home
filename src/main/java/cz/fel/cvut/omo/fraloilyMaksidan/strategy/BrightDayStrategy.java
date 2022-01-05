package cz.fel.cvut.omo.fraloilyMaksidan.strategy;

public class BrightDayStrategy extends Strategy {
    BrightDayStrategy() {
        this.sunGoesUp = 6;
        this.sunGoesDown = 19;
        this.tempChange = -1;
        this.humidityChange = -2;
        this.oxygenChange = -1;
    }
}
