package Persistence;

import org.json.JSONObject;

public interface IAttractionPersistence {
    void chargeAttraction(String file, AttractionManagement attractionMg);
    void saveAttraction(String file, AttractionManagement attractionMg);
}

