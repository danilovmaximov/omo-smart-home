package cz.fel.cvut.omo.fraloilyMaksidan.parsing.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class EntityModel {
    @JsonProperty private String name;
    @JsonProperty private String type;
    @JsonProperty private List<String> activities;

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public List<String> getActivities() {
        return activities;
    }
}
