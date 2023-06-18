package Writers;

import Model.Manufacturer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JsonReader {

    public void writeJson(List<Manufacturer> manufacturers, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(manufacturers, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
