package com.example.android.bakingapp.data;

import android.content.Context;

import java.util.List;

public interface RecipesDataSource {
    List<Recipe> loadRecipes(Context context);
}
