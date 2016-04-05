package com.test.myapplication.model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by bon on 16/03/29.
 */
public class SimpleImageName {

    private String name;
    private String image;

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setJSONObject(JSONObject object) {
        try {

            if (object.has("name")) {
                this.setName(object.getString("name"));
            }

            if (object.has("image")) {
                this.setImage(object.getString("image"));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
