package org.jaeyeal.lab.app.lab;

import com.google.gson.JsonObject;
import org.springframework.boot.configurationprocessor.json.JSONObject;

public class JsonObjectLab {
    public static void main(String[] args) {
        JsonObject obj = new JsonObject();
        JsonObject subObj = new JsonObject();
        subObj.addProperty("M","img1");
        subObj.addProperty("1","img2");
        subObj.addProperty("2","img3");
        subObj.addProperty("3","img4");
        obj.add("position", subObj);
        System.out.println("obj = " + obj);

    }
}
