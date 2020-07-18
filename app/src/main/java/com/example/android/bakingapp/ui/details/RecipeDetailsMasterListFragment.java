package com.example.android.bakingapp.ui.details;

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

import com.example.android.bakingapp.R;
import com.example.android.bakingapp.data.Recipe;
import com.example.android.bakingapp.ui.step.StepActivity;

import java.util.List;

import timber.log.Timber;

public class RecipeDetailsMasterListFragment extends Fragment implements
        RecipeDetailsMasterListAdapter.OnRecipeStepClickListener {

    List<Recipe.Step> mRecipeSteps;
    int mRecipeIndex;

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

    public void setRecipeIndex(int mRecipeIndex) {
        this.mRecipeIndex = mRecipeIndex;
    }

    @Override
    public void onRecipeStepClick(Recipe.Step step, int viewType, int position) {

        switch (viewType) {
            case RecipeDetailsMasterListAdapter.VIEW_TYPE_INGREDIENTS:
                Timber.d("Click on the ingredients");
                break;
            case RecipeDetailsMasterListAdapter.VIEW_TYPE_STEP:
                startStepActivity(position);
                break;
            default:
                Timber.d("Invalid view type, value of %s", viewType);
        }
    }

    private void startStepActivity(int position) {
        Intent intent = new Intent(getActivity(), StepActivity.class);
        intent.putExtra(StepActivity.EXTRA_CURRENT_STEP_INDEX, position);
        intent.putExtra(StepActivity.EXTRA_RECIPE_INDEX, mRecipeIndex);
        startActivity(intent);
    }
}
