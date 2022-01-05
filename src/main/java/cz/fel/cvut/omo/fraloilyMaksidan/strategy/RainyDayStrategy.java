package cz.fel.cvut.omo.fraloilyMaksidan.strategy;

import cz.fel.cvut.omo.fraloilyMaksidan.Context;

public class RainyDayStrategy extends Strategy {
    public RainyDayStrategy() {
        this.sunGoesUp = 7;
        this.sunGoesDown = 17;
        this.tempChange = -2;
        this.humidityChange = -1;
        this.oxygenChange = -2;
    }
}
