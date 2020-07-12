package com.example.android.bakingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.RecipeHolder> {

    List<Recipe> mRecipesData;
    private OnRecipeClickListener recipeClickListener;

    public RecipeListAdapter(OnRecipeClickListener recipeClickListener) {
        this.recipeClickListener = recipeClickListener;
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeHolder holder, int position) {
        holder.recipeName.setText(mRecipesData.get(position).getName());
    }

    @NonNull
    @Override
    public RecipeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recipe_list_item, parent, false);
        return new RecipeHolder(view);
    }

    @Override
    public int getItemCount() {
        return (mRecipesData == null ? 0 : mRecipesData.size());
    }

    public void setRecipesData(List<Recipe> mRecipesData) {
        this.mRecipesData = mRecipesData;
    }

    public interface OnRecipeClickListener {
        void onRecipeClick(Recipe recipe);
    }

    public class RecipeHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView recipeName;

        public RecipeHolder(@NonNull View itemView) {
            super(itemView);
            recipeName = itemView.findViewById(R.id.tv_recipe_name);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Recipe recipe = mRecipesData.get(getAdapterPosition());
            recipeClickListener.onRecipeClick(recipe);
        }
    }
}
