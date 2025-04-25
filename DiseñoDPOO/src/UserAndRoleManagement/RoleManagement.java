package UserAndRoleManagement;

import java.util.HashMap;
import java.util.Map;

public class RoleManagement {

    private Map<String, String> userRoles;

    public RoleManagement() {
        this.userRoles = new HashMap<>();
    }

    public String getUserRole(String username) {
        return userRoles.getOrDefault(username, "Guest");
    }

    public void assignUserRole(User user, String role) {
        user.setRol(role);
        userRoles.put(user.getUsername(), role);
    }
}

