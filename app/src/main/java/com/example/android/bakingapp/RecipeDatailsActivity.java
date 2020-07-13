package com.example.android.bakingapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class RecipeDatailsActivity extends AppCompatActivity {
    public static final String EXTRA_RECIPE = "extra-recipe";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_datails);

        // Enable UP button
        if (getActionBar() != null) {
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Intent intent = getIntent();
        Recipe recipe = null;
        if (intent != null && intent.hasExtra(EXTRA_RECIPE)) {
            recipe = intent.getParcelableExtra(EXTRA_RECIPE);
        }

        RecipeDetailsMasterListFragment recipeDetailFragment = new RecipeDetailsMasterListFragment();
        recipeDetailFragment.setRecipeSteps(recipe.getSteps());

        // Add the fragment to its container using a FragmentManager and a Transaction
        FragmentManager fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction()
                .add(R.id.frame_recipe_container, recipeDetailFragment)
                .commit();
    }
}