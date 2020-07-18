package com.example.android.bakingapp.ui.main;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.android.bakingapp.data.RecipesRepository;

public class MainActivityModelFactory extends ViewModelProvider.NewInstanceFactory {
    private final RecipesRepository mRepository;
    private final Context mContext;

    public MainActivityModelFactory(Context context, RecipesRepository repository) {
        mRepository = repository;
        mContext = context;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new MainActivityViewModel(mContext, mRepository);
    }
}
