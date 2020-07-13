package com.example.android.bakingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import timber.log.Timber;

public class RecipeDetailsMasterListFragment extends Fragment implements
        RecipeDetailsMasterListAdapter.OnRecipeStepClickListener {

    List<Recipe.Step> mRecipeSteps;

    public RecipeDetailsMasterListFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.recipe_details_master_list, container, false);

        RecyclerView recyclerView = rootView.findViewById(R.id.rv_recipe_details_master_list);
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(rootView.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        RecipeDetailsMasterListAdapter recipeDetailsAdapter = new RecipeDetailsMasterListAdapter(this);
        recipeDetailsAdapter.setStepsData(mRecipeSteps);
        recyclerView.setAdapter(recipeDetailsAdapter);

        return rootView;
    }

    public void setRecipeSteps(List<Recipe.Step> recipeSteps) {
        mRecipeSteps = recipeSteps;
    }

    @Override
    public void onRecipeStepClick(Recipe.Step step, int viewType) {
        Intent intent = null;
        switch (viewType) {
            case RecipeDetailsMasterListAdapter.VIEW_TYPE_INGREDIENTS:
                Timber.d("Click on the ingredients");
                break;
            case RecipeDetailsMasterListAdapter.VIEW_TYPE_STEP:
                Timber.d("Click on the step: " + step.getShortDescription());
                break;
            default:
                Timber.d("Invalid view type, value of " + viewType);
        }
    }
}
