package com.example.android.bakingapp.utils;

import android.content.Context;

import com.example.android.bakingapp.Recipe;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class DataUtils {
    private static final String RECIPES_JSON_SOURCE_FILE = "baking.json";

    public static String loadJsonFromAssets(Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open(RECIPES_JSON_SOURCE_FILE);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

        return json;
    }

    public static List<Recipe> loadRecipesFromJson(Context context) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        Type listType = new TypeToken<List<Recipe>>() {
        }.getType();
        List<Recipe> recipes = gson.fromJson(loadJsonFromAssets(context), listType);

        return recipes;
    }
}
