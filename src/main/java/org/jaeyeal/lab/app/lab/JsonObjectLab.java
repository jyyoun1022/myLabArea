package org.jaeyeal.lab.app.lab;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.boot.configurationprocessor.json.JSONObject;

public class JsonObjectLab {
    public static void main(String[] args) {
        Gson gson = new Gson();
        JsonObject syncMessageObject = new JsonObject();

        JsonObject positionObject = new JsonObject();
        positionObject.addProperty("M", "main1");
        positionObject.addProperty("1", "path1");
        positionObject.addProperty("2", "path2");
        positionObject.addProperty("3", "path3");
        positionObject.addProperty("4", "path4");
        positionObject.addProperty("5", "path5");

        syncMessageObject.add("position", positionObject);

        syncMessageObject.addProperty("workSetNamePrefix", "SW");

        System.out.println("syncMessageObject = " + syncMessageObject);
        String syncMessageObjectStr = gson.toJson(syncMessageObject);
        System.out.println("syncMessageObjectStr = " + syncMessageObjectStr);


    }
}
