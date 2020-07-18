package com.example.android.bakingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecipeDetailsMasterListAdapter extends RecyclerView.Adapter<RecipeDetailsMasterListAdapter.RecipesViewHolder> {
    public static final int VIEW_TYPE_INGREDIENTS = 0;
    public static final int VIEW_TYPE_STEP = 1;

    private List<Recipe.Step> mStepsData;
    private OnRecipeStepClickListener mStepsClickListener;

    public RecipeDetailsMasterListAdapter(OnRecipeStepClickListener stepsClickListener) {
        this.mStepsClickListener = stepsClickListener;
    }

    @NonNull
    @Override
    public RecipesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recipe_details_item, parent, false);
        return new RecipeDetailsMasterListAdapter.RecipesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipesViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        switch (viewType) {
            case VIEW_TYPE_INGREDIENTS:
                holder.ingredientsLabel.setVisibility(View.VISIBLE);
                holder.stepName.setVisibility(View.INVISIBLE);
                break;
            case VIEW_TYPE_STEP:
                holder.ingredientsLabel.setVisibility(View.INVISIBLE);
                holder.stepName.setVisibility(View.VISIBLE);
                /* steps are starting from the second view item, so we need to adjust
                 * to get valid index into mStepsData */
                holder.stepName.setText(mStepsData.get(position - 1).getShortDescription());
                break;
            default:
                throw new IllegalArgumentException("Invalid view type, value of " + viewType);
        }
    }

    @Override
    public int getItemCount() {
        /*
         * Extra one because we want to show "Ingredients" as the first item
         * */
        return mStepsData == null ? 0 : mStepsData.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        return position == 0 ? VIEW_TYPE_INGREDIENTS : VIEW_TYPE_STEP;
    }

    public void setStepsData(List<Recipe.Step> steps) {
        mStepsData = steps;
    }

    public interface OnRecipeStepClickListener {
        void onRecipeStepClick(Recipe.Step step, int viewType, int position);
    }

    class RecipesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView ingredientsLabel;
        TextView stepName;

        public RecipesViewHolder(@NonNull View itemView) {
            super(itemView);
            ingredientsLabel = itemView.findViewById(R.id.tv_ingredients_label);
            stepName = itemView.findViewById(R.id.tv_step_name);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int viewType = getItemViewType();
            switch (viewType) {
                case VIEW_TYPE_INGREDIENTS:
                    mStepsClickListener.onRecipeStepClick(null, viewType, -1);
                    break;
                case VIEW_TYPE_STEP:
                    Recipe.Step step = mStepsData.get(getAdapterPosition() - 1);
                    mStepsClickListener.onRecipeStepClick(step, viewType, getAdapterPosition() - 1);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid view type, value of " + viewType);
            }
        }
    }
}
