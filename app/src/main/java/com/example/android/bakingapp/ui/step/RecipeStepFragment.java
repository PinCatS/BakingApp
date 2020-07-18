package com.example.android.bakingapp.ui.step;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.android.bakingapp.R;
import com.example.android.bakingapp.data.Recipe;

public class RecipeStepFragment extends Fragment {

    Recipe.Step step;

    public RecipeStepFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_recipe_step, container, false);

        if (step != null) {
            TextView textView = rootView.findViewById(R.id.tv_step_description);
            textView.setText(step.getDescription());
        }

        return rootView;
    }

    public void setStep(Recipe.Step step) {
        this.step = step;
    }
}
