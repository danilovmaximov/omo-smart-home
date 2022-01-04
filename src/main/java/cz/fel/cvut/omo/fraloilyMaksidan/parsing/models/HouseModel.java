package cz.fel.cvut.omo.fraloilyMaksidan.parsing.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import cz.fel.cvut.omo.fraloilyMaksidan.parsing.models.ActivityModel;
import cz.fel.cvut.omo.fraloilyMaksidan.parsing.models.EntityModel;
import cz.fel.cvut.omo.fraloilyMaksidan.parsing.models.FloorModel;

import java.util.List;

public class HouseModel {
    @JsonProperty private String address;
    @JsonProperty private List<FloorModel> floors;
    @JsonProperty private List<ActivityModel> activities;
    @JsonProperty private List<EntityModel> entities;

    public String getAddress() {
        return address;
    }

    public List<FloorModel> getFloors() {
        return floors;
    }

    public List<ActivityModel> getActivities() {
        return activities;
    }

    public List<EntityModel> getEntities() {
        return entities;
    }
}
