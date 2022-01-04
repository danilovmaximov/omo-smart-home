package cz.fel.cvut.omo.fraloilyMaksidan.parsing.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ActivityModel {
    @JsonProperty private String name;
    @JsonProperty private String room;

    public String getName() {
        return name;
    }

    public String getRoom() {
        return room;
    }
}
