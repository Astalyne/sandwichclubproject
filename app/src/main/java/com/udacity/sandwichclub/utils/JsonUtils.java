package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {
    public static final String JSON_NAME = "name";
    public static final String JSON_MAIN_NAME = "mainName";
    public static final String JSON_ALSO_KNOWN_AS = "alsoKnownAs";
    public static final String JSON_PLACE_OF_ORIGIN = "placeOfOrigin";
    public static final String JSON_DESCRIPTION = "description";
    public static final String JSON_IMAGE = "image";
    public static final String JSON_INGREDIENTS = "ingredients";





    public static Sandwich parseSandwichJson(String json) {
        Sandwich sw = new Sandwich();



        try{

            JSONObject jobject = new JSONObject(json);
    JSONObject object = jobject.getJSONObject(JSON_NAME);
            JSONArray alsoKnownAsJsonArray = object.getJSONArray(JSON_ALSO_KNOWN_AS);

            List<String> alsoKnownAsArray = new ArrayList<>();

            for (int i = 0; i<alsoKnownAsJsonArray.length();i++){

                alsoKnownAsArray.add(alsoKnownAsJsonArray.getString(i));

            }
            sw.setAlsoKnownAs(alsoKnownAsArray);

            sw.setDescription(jobject.getString(JSON_DESCRIPTION));
            sw.setImage(jobject.getString(JSON_IMAGE));
            sw.setPlaceOfOrigin(jobject.getString(JSON_PLACE_OF_ORIGIN));

            List<String> ing = new ArrayList<>();
            JSONArray ingArray = jobject.getJSONArray(JSON_INGREDIENTS);
            for (int i =0; i<ingArray.length();i++){
                ing.add(ingArray.getString(i));
            }
            sw.setIngredients(ing);






        }catch (JSONException e){
            e.printStackTrace();
        }
        return sw;
    }
}
