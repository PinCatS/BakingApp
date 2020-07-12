package com.example.android.bakingapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android.bakingapp.utils.DataUtils;

import java.util.List;

import timber.log.Timber;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Timber fr logging
        Timber.plant(new Timber.DebugTree());

        List<Recipe> recipes = DataUtils.loadRecipesFromJson(this);
    }

}