package UserAndRoleManagement;

import java.util.HashMap;
import java.util.Map;

public class UserProfileManagement {

    private Map<String, User> users;

    public UserProfileManagement() {
        this.users = new HashMap<>();
    }

    public User getUserProfile(String username) {
        return users.get(username);
    }

    public void updateUserProfile(String username, String newName, String newEmail) {
        User user = users.get(username);
        if (user != null) {
            user.setName(newName);
            user.setEmail(newEmail);
        }
    }

    public void createUser(String username, String name, String email, String password) {
        Client newUser = new Client(username, name, email, password);
        users.put(username, newUser);
    }

    public Map<String, User> getUsers() {
        return users;
    }
}

