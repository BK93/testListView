package com.test.myapplication.model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by bon on 16/03/29.
 */
public class SimpleName {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setJSONObject(JSONObject nameJson) {
        try {

            if (nameJson.has("name")) {
                this.setName(nameJson.getString("name"));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
