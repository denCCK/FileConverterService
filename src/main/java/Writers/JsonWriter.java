package Writers;

import Model.Manufacturer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonWriter {
    private final ArrayList<Manufacturer> MANUFACTURERS;

    public JsonWriter(ArrayList<Manufacturer> manufacturers) {
        this.MANUFACTURERS = manufacturers;
    }
    public void writeJson(String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(MANUFACTURERS, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
