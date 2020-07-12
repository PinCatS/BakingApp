package com.example.android.bakingapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.bakingapp.utils.DataUtils;

import java.util.List;

import timber.log.Timber;

public class MainActivity extends AppCompatActivity implements
        RecipeListAdapter.OnRecipeClickListener {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Timber fr logging
        Timber.plant(new Timber.DebugTree());

        RecyclerView recyclerView = findViewById(R.id.rv_recipe_list);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        RecipeListAdapter recipesAdapter = new RecipeListAdapter(this);

        List<Recipe> recipes = DataUtils.loadRecipesFromJson(this);
        recipesAdapter.setRecipesData(recipes);
        recyclerView.setAdapter(recipesAdapter);
    }

    @Override
    public void onRecipeClick(Recipe recipe) {
        Intent intent = new Intent(this, RecipeDatailsActivity.class);
        startActivity(intent);
    }
}