package com.example.android.bakingapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

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
    }
}