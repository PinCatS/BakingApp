package com.example.android.bakingapp.ui.step;

import android.content.Context;

import androidx.lifecycle.ViewModel;

import com.example.android.bakingapp.data.Recipe;
import com.example.android.bakingapp.data.RecipesRepository;

import java.util.List;

public class StepActivityViewModel extends ViewModel {
    private RecipesRepository mRepository;
    private List<Recipe> mRecipes;

    public StepActivityViewModel(Context context, RecipesRepository repository) {
        mRepository = repository;
        mRecipes = mRepository.loadRecipes(context);
    }

    public List<Recipe> getRecipes() {
        return mRecipes;
    }
}
