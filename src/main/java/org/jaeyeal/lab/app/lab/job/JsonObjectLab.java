package org.jaeyeal.lab.app.lab.job;

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


        System.out.println("syncMessageObject = " + syncMessageObject.size());


        JsonObject testObject = new JsonObject();
        testObject.addProperty("position1", "1");
        testObject.addProperty("position2", "2");

        JsonObject subObject = new JsonObject();
        subObject.addProperty("subPosition1", "3");
        subObject.addProperty("subPosition2", "4");
        testObject.add("ee", subObject);
        // JsonObject size는 제일 객체안의 키의 개수를 리턴
        System.out.println(testObject);
        System.out.println("testObject.size() = " + testObject.size());
    }
}
