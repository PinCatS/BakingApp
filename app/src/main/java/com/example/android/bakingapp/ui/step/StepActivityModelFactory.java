package com.example.android.bakingapp.ui.step;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.android.bakingapp.data.RecipesRepository;

public class StepActivityModelFactory extends ViewModelProvider.NewInstanceFactory {
    private final RecipesRepository mRepository;
    private final Context mContext;

    public StepActivityModelFactory(Context context, RecipesRepository repository) {
        mRepository = repository;
        mContext = context;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new StepActivityViewModel(mContext, mRepository);
    }
}
