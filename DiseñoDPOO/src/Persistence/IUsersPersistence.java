package Persistence;

import org.json.JSONObject;

public interface IUsersPersistence {
    void chargeUsers(String file, UserProfileManagement userMg);
    void saveUsers(String file, UserProfileManagement userMg);
}

