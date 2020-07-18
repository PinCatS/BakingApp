package com.example.android.bakingapp.ui.details;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.android.bakingapp.R;
import com.example.android.bakingapp.data.Recipe;

public class RecipeDatailsActivity extends AppCompatActivity {
    public static final String EXTRA_RECIPE = "extra-recipe";
    public static final String EXTRA_RECIPE_INDEX = "extra-recipe-index";

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
        int recipeIndex = 0;
        if (intent != null) {
            if (intent.hasExtra(EXTRA_RECIPE)) {
                recipe = intent.getParcelableExtra(EXTRA_RECIPE);
            }

            recipeIndex = intent.getIntExtra(EXTRA_RECIPE_INDEX, 0);
        }

        RecipeDetailsMasterListFragment recipeDetailFragment = new RecipeDetailsMasterListFragment();
        recipeDetailFragment.setRecipeSteps(recipe.getSteps());
        recipeDetailFragment.setRecipeIndex(recipeIndex);

        // Add the fragment to its container using a FragmentManager and a Transaction
        FragmentManager fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction()
                .add(R.id.frame_recipe_container, recipeDetailFragment)
                .commit();
    }
}