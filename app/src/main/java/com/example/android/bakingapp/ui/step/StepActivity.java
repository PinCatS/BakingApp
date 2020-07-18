package com.example.android.bakingapp.ui.step;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import com.example.android.bakingapp.R;
import com.example.android.bakingapp.data.Recipe;
import com.example.android.bakingapp.utils.InjectorUtils;

import java.util.List;

public class StepActivity extends AppCompatActivity {
    public static final String EXTRA_STEP = "extra-step";
    public static final String EXTRA_CURRENT_STEP_INDEX = "extra-current-step-index";
    public static final String EXTRA_RECIPE_INDEX = "extra-recipe-index";

    List<Recipe.Step> mSteps;
    int mCurrentStepIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step);

        Intent intent = getIntent();
        int recipeIndex = 0;
        if (intent != null) {
            mCurrentStepIndex = intent.getIntExtra(EXTRA_CURRENT_STEP_INDEX, 0);
            recipeIndex = intent.getIntExtra(EXTRA_RECIPE_INDEX, 0);
        }

        StepActivityModelFactory modelViewFactory = InjectorUtils.provideStepActivityModelFactory(this);
        StepActivityViewModel modelView = new ViewModelProvider(this, modelViewFactory).get(StepActivityViewModel.class);

        mSteps = modelView.getRecipes().get(recipeIndex).getSteps();
        Recipe.Step step = mSteps.get(mCurrentStepIndex);

        FragmentManager fragmentManager = getSupportFragmentManager();

        RecipeStepFragment recipeStepFragment = new RecipeStepFragment();
        recipeStepFragment.setStep(step);
        fragmentManager.beginTransaction()
                .add(R.id.container_step_fragment, recipeStepFragment)
                .commit();
    }

    public void onNextStepClick(View view) {
        if (mCurrentStepIndex < mSteps.size() - 1) {
            mCurrentStepIndex++;
        } else {
            mCurrentStepIndex = 0;
        }

        replaceStepFragment();
    }

    public void onPrevStepClick(View view) {
        if (mCurrentStepIndex > 0) {
            mCurrentStepIndex--;
        } else {
            mCurrentStepIndex = mSteps.size() - 1;
        }

        replaceStepFragment();
    }

    private void replaceStepFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();

        RecipeStepFragment recipeStepFragment = new RecipeStepFragment();
        recipeStepFragment.setStep(mSteps.get(mCurrentStepIndex));

        fragmentManager.beginTransaction()
                .replace(R.id.container_step_fragment, recipeStepFragment)
                .commit();
    }
}