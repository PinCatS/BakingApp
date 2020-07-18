package com.example.android.bakingapp.data;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class RecipesAssetsSource implements RecipesDataSource {
    private static final String RECIPES_JSON_SOURCE_FILE = "baking.json";

    private List<Recipe> mRecipes;

    private static String loadJsonFromAssets(Context context) {
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

    private static List<Recipe> loadRecipesFromJson(Context context) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        Type listType = new TypeToken<List<Recipe>>() {
        }.getType();
        List<Recipe> recipes = gson.fromJson(loadJsonFromAssets(context), listType);

        return recipes;
    }

    @Override
    public List<Recipe> loadRecipes(Context context) {
        if (mRecipes == null) {
            mRecipes = loadRecipesFromJson(context);
        }
        return mRecipes;
    }
}
