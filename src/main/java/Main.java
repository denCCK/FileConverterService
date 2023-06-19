import Model.Manufacturer;
import Readers.JsonReader;
import Readers.XmlReader;
import Writers.JsonWriter;
import Writers.XmlWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            System.out.println("Необходимо указать пути к файлам XML и JSON");
            return;
        }

        String inputFile = "Manufacturer.xml";
        String outputFile = "output.json";

        String inputExtension = getFileExtension(inputFile);

        if (inputExtension.equalsIgnoreCase("xml")) {
            // Преобразование XML в JSON
            ArrayList<Manufacturer> manufacturers = readXml(inputFile);
            if (manufacturers != null) {
                writeJson(outputFile, manufacturers);
                System.out.println("Преобразование XML в JSON завершено");
            }
        } else if (inputExtension.equalsIgnoreCase("json")) {
            // Преобразование JSON в XML
            ArrayList<Manufacturer> manufacturers = readJson(inputFile);
            if (manufacturers != null) {
                writeXml(outputFile, manufacturers);
                System.out.println("Преобразование JSON в XML завершено");
            }
        } else {
            System.out.println("Неподдерживаемый формат файла");
        }
    }

    private static String getFileExtension(String filePath) {
        int dotIndex = filePath.lastIndexOf(".");
        if (dotIndex > 0 && dotIndex < filePath.length() - 1) {
            return filePath.substring(dotIndex + 1);
        }
        return "";
    }

    private static ArrayList<Manufacturer> readXml(String filePath) {
        XmlReader reader = new XmlReader(filePath);
        return reader.read();
    }

    private static void writeJson(String filePath, ArrayList<Manufacturer> manufacturers) {
        JsonWriter writer = new JsonWriter(manufacturers);
        writer.write(filePath);
    }

    private static ArrayList<Manufacturer> readJson(String filePath) throws IOException {
        JsonReader reader = new JsonReader(filePath);
        return reader.read();
    }

    private static void writeXml(String filePath, ArrayList<Manufacturer> manufacturers) {
        XmlWriter writer = new XmlWriter(manufacturers);
        writer.write(filePath);
    }

}
