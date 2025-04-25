package Persistence;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class UsersPersistence implements IUsersPersistence {

    @Override
    public void chargeUsers(String file, UserProfileManagement userMg) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(file)));
            JSONArray usersArray = new JSONArray(content);

            for (int i = 0; i < usersArray.length(); i++) {
                JSONObject obj = usersArray.getJSONObject(i);
                String username = obj.getString("username");
                String name = obj.getString("name");
                String email = obj.getString("email");
                String password = obj.getString("password");
                userMg.createUser(username, name, email, password);
            }

            System.out.println("Usuarios cargados correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveUsers(String file, UserProfileManagement userMg) {
        JSONArray usersArray = new JSONArray();

        for (User user : userMg.getUsers().values()) {
            JSONObject obj = new JSONObject();
            obj.put("username", user.getUsername());
            obj.put("name", user.getName());
            obj.put("email", user.getEmail());
            obj.put("rol", user.getRol());
            usersArray.put(obj);
        }

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(usersArray.toString(2));
            System.out.println("Usuarios guardados correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

