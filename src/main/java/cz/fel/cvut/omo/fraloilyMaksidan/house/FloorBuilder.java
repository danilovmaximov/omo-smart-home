package cz.fel.cvut.omo.fraloilyMaksidan.house;

import cz.fel.cvut.omo.fraloilyMaksidan.appliances.Appliance;
import cz.fel.cvut.omo.fraloilyMaksidan.entities.LivingEntity;

public interface FloorBuilder {
    void reset();
    void addAppliance(Appliance appliance);
    void addEntity(LivingEntity entity);
}
