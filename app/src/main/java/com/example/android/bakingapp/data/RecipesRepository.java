package com.example.android.bakingapp.data;

import android.content.Context;

import java.util.List;

public class RecipesRepository {
    private static final Object LOCK = new Object();
    private static RecipesRepository sInstance;
    private RecipesDataSource recipesDataSource;

    private RecipesRepository(RecipesDataSource recipesSource) {
        recipesDataSource = recipesSource;
    }

    public synchronized static RecipesRepository getInstance(RecipesDataSource recipesSource) {
        if (sInstance == null) {
            synchronized (LOCK) {
                sInstance = new RecipesRepository(recipesSource);
            }
        }
        return sInstance;
    }

    public List<Recipe> loadRecipes(Context context) {
        return recipesDataSource.loadRecipes(context);
    }
}
