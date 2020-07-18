package com.example.android.bakingapp.ui.main;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.bakingapp.R;
import com.example.android.bakingapp.data.Recipe;
import com.example.android.bakingapp.ui.details.RecipeDatailsActivity;
import com.example.android.bakingapp.utils.InjectorUtils;

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

        MainActivityModelFactory modelViewFactory = InjectorUtils.provideMainActivityModelFactory(this);
        MainActivityViewModel modelView = new ViewModelProvider(this, modelViewFactory).get(MainActivityViewModel.class);
        recipesAdapter.setRecipesData(modelView.getRecipes());
        recyclerView.setAdapter(recipesAdapter);
    }

    @Override
    public void onRecipeClick(Recipe recipe, int position) {
        Intent intent = new Intent(this, RecipeDatailsActivity.class);
        intent.putExtra(RecipeDatailsActivity.EXTRA_RECIPE, recipe);
        intent.putExtra(RecipeDatailsActivity.EXTRA_RECIPE_INDEX, position);
        startActivity(intent);
    }
}