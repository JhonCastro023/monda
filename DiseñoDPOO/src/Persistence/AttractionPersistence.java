package Persistence;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AttractionPersistence implements IAttractionPersistence {

    @Override
    public void chargeAttraction(String file, AttractionManagement attractionMg) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(file)));
            JSONArray attractionsArray = new JSONArray(content);

            for (int i = 0; i < attractionsArray.length(); i++) {
                JSONObject obj = attractionsArray.getJSONObject(i);
                String id = obj.getString("id");
                String name = obj.getString("name");
                String category = obj.getString("category");

                attractionMg.addAttraction(id, name, category); // Método supuesto
            }

            System.out.println("Atracciones cargadas correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveAttraction(String file, AttractionManagement attractionMg) {
        JSONArray attractionsArray = new JSONArray();

        for (Attraction attraction : attractionMg.getAllAttractions()) {
            JSONObject obj = new JSONObject();
            obj.put("id", attraction.getId());
            obj.put("name", attraction.getName());
            obj.put("category", attraction.getCategory());
            attractionsArray.put(obj);
        }

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(attractionsArray.toString(2));
            System.out.println("Atracciones guardadas correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

