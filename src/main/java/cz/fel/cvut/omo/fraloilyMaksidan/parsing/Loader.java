package cz.fel.cvut.omo.fraloilyMaksidan.parsing;

import com.fasterxml.jackson.databind.ObjectMapper;
import cz.fel.cvut.omo.fraloilyMaksidan.parsing.models.HouseModel;

import java.io.FileReader;
import java.io.IOException;
/**
    Maps json to models.
 */
public class Loader {
    private static final ObjectMapper mapper = new ObjectMapper();
    private static String prefix = "./src/main/resources/json/";


    public static HouseModel loadFromJSON(String filename) {
        try {
            return mapper.readValue(new FileReader(prefix+filename), HouseModel.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void setPrefix(String newPrefix) {
        prefix = newPrefix;
    }

    public static String getPrefix() {
        return prefix;
    }



}