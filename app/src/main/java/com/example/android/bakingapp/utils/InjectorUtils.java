package com.example.android.bakingapp.utils;

import android.content.Context;

import com.example.android.bakingapp.data.RecipesAssetsSource;
import com.example.android.bakingapp.data.RecipesRepository;
import com.example.android.bakingapp.ui.main.MainActivityModelFactory;
import com.example.android.bakingapp.ui.step.StepActivityModelFactory;

public class InjectorUtils {
    public static RecipesRepository provideRepository() {
        return RecipesRepository.getInstance(new RecipesAssetsSource());
    }

    public static MainActivityModelFactory provideMainActivityModelFactory(Context context) {
        return new MainActivityModelFactory(context, provideRepository());
    }

    public static StepActivityModelFactory provideStepActivityModelFactory(Context context) {
        return new StepActivityModelFactory(context, provideRepository());
    }
}