package cz.fel.cvut.omo.fraloilyMaksidan.strategy;

import cz.fel.cvut.omo.fraloilyMaksidan.Context;
import cz.fel.cvut.omo.fraloilyMaksidan.house.MapContext;

public abstract class Strategy {
    protected int tempChange;
    protected int humidityChange;
    protected int oxygenChange;
    protected int sunGoesUp;
    protected int sunGoesDown;

    public void changeConditions() {
        Context.nextHour();
        if (Context.getCurrentTime() > sunGoesDown && Context.itsBright()) {
            Context.setSun(false);
        } else if (Context.getCurrentTime() > sunGoesUp && !Context.itsBright()) {
            Context.setSun(true);
        }

        Context.changeTempLevel(tempChange);
        Context.changeHumidityLevel(humidityChange + MapContext.getHouseHumidifier().getHumidityChange());
        Context.changeOxygenLevel(oxygenChange + MapContext.getHouseWindows().getOxygenChange());
    }
}
