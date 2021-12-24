package cz.fel.cvut.omo.fraloilyMaksidan.house;

import cz.fel.cvut.omo.fraloilyMaksidan.appliances.Appliance;
import cz.fel.cvut.omo.fraloilyMaksidan.entities.LivingEntity;
import java.util.ArrayList;
import java.util.List;

public class Floor {
    //List<Appliance> appliances = new ArrayList<>();
    List<LivingEntity> entities = new ArrayList<>();
    List<Window> windows = new ArrayList<>();


    public void addEntities(LivingEntity entity) {
        entities.add(entity);
    }

    public void addWindows(Window window) {
        windows.add(window);
    }
}
