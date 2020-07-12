package com.example.android.bakingapp;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecipeDetailsMasterListAdapter extends RecyclerView.Adapter<RecipeDetailsMasterListAdapter.RecipesViewHolder> {

    @NonNull
    @Override
    public RecipesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecipesViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    static class RecipesViewHolder extends RecyclerView.ViewHolder {

        public RecipesViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
