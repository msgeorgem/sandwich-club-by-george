package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {

        Sandwich sandwich = null;

        try {
            JSONObject root = new JSONObject(json);

            JSONObject subObject = root.getJSONObject("name");

            String mainName = subObject.getString("mainName");
            JSONArray aKa = subObject.getJSONArray("alsoKnownAs");
            List<String> alsoKnownAsList = new ArrayList<>();

            for (int i = 0; i < aKa.length(); i++) {
                String alsoKnownAs = aKa.getString(i);
                alsoKnownAsList.add(alsoKnownAs);
            }

            String placeOfOrigin = root.getString("placeOfOrigin");
            String description = root.getString("description");
            String imagePath = root.getString("image");
            JSONArray ingredientsArray = root.getJSONArray("ingredients");

            List<String> ingredientList = new ArrayList<>();
            for (int i = 0; i < ingredientsArray.length(); i++) {
                String ingredient = ingredientsArray.getString(i);
                ingredientList.add(ingredient);

            }

            sandwich = new Sandwich(mainName, alsoKnownAsList, placeOfOrigin, description, imagePath, ingredientList);

        } catch (JSONException e) {
            e.printStackTrace();

        }

        return sandwich;
    }
}