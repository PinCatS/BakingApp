package com.example.android.bakingapp.ui.main;

import android.content.Context;

import androidx.lifecycle.ViewModel;

import com.example.android.bakingapp.data.Recipe;
import com.example.android.bakingapp.data.RecipesRepository;

import java.util.List;

public class MainActivityViewModel extends ViewModel {
    private RecipesRepository mRepository;
    private List<Recipe> mRecipes;

    public MainActivityViewModel(Context context, RecipesRepository repository) {
        mRepository = repository;
        mRecipes = mRepository.loadRecipes(context);
    }

    public List<Recipe> getRecipes() {
        return mRecipes;
    }
}
