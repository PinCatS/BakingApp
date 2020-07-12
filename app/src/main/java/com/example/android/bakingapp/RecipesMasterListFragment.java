package com.example.android.bakingapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.bakingapp.utils.DataUtils;

import java.util.List;

public class RecipesMasterListFragment extends Fragment {

    public RecipesMasterListFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.recipes_master_list, container, false);


        RecyclerView recyclerView = rootView.findViewById(R.id.rv_recipes_master_list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        RecipesMasterListAdapter recipesAdapter = new RecipesMasterListAdapter();

        List<Recipe> recipes = DataUtils.loadRecipesFromJson(this.getContext());
        recipesAdapter.setRecipesData(recipes);
        recyclerView.setAdapter(recipesAdapter);

        return rootView;
    }

}
