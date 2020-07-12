package com.example.android.bakingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecipesMasterListAdapter extends RecyclerView.Adapter<RecipesMasterListAdapter.RecipesViewHolder> {

    List<Recipe> recipesData;

    @NonNull
    @Override
    public RecipesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recipe_list_item, parent, false);
        return new RecipesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipesViewHolder holder, int position) {
        holder.recipeName.setText(recipesData.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return (recipesData == null ? 0 : recipesData.size());
    }

    public void setRecipesData(List<Recipe> recipesData) {
        this.recipesData = recipesData;
    }

    static class RecipesViewHolder extends RecyclerView.ViewHolder {
        TextView recipeName;

        public RecipesViewHolder(@NonNull View itemView) {
            super(itemView);
            recipeName = itemView.findViewById(R.id.tv_recipe_name);
        }
    }
}
