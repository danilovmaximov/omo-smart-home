package cz.fel.cvut.omo.fraloilyMaksidan.parsing.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class FloorModel {
    @JsonProperty private int floorNumber;
    @JsonProperty private List<String> rooms;

    public int getFloorNumber() {
        return floorNumber;
    }

    public List<String> getRooms() {
        return rooms;
    }
}
