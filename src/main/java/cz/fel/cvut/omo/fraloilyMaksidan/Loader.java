package cz.fel.cvut.omo.fraloilyMaksidan;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileReader;
import java.io.IOException;

public class Loader {
  private final ObjectMapper mapper = new ObjectMapper();



  public void loadFromJSON(String filename) {
    try {
      JsonNode rootNode = mapper.readTree(new FileReader(filename));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
