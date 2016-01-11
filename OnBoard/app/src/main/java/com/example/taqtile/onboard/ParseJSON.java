package com.example.taqtile.onboard;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by taqtile on 1/10/16.
 */
public class ParseJSON {
    public static String[] ids;
    public static String[] names;
    public static String[] lastNames;
    public static String[] emails;
    public static Integer size;

    public static final String JSON_ARRAY = "data";
    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "first_name";
    public static final String KEY_LAST_NAME = "last_name";
    public static final String KEY_EMAIL = "avatar";
    public static final String SIZE = "per_page";

    private JSONArray users = null;

    private String json;

    public ParseJSON(String json){
        this.json = json;
    }

    protected void parseJSON() {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(json);
            users = jsonObject.getJSONArray(JSON_ARRAY);
            size = Integer.parseInt(jsonObject.getString(SIZE));

            ids = new String[users.length()];
            names = new String[users.length()];
            lastNames = new String[users.length()];
            emails = new String[users.length()];

            for (int i = 0; i < users.length(); i++) {
                JSONObject jo = users.getJSONObject(i);
                ids[i] = jo.getString(KEY_ID);
                names[i] = jo.getString(KEY_NAME);
                lastNames[i] = jo.getString(KEY_LAST_NAME);
                emails[i] = jo.getString(KEY_EMAIL);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
