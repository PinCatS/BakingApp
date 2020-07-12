package com.example.android.bakingapp;

import java.util.ArrayList;
import java.util.List;

public class Recipe {
    private int id;
    private String name;
    private List<Ingredient> ingredients = new ArrayList<>();
    private List<Step> steps = new ArrayList<>();
    private int servings;
    private String recipeImage;

    public String getName() {
        return name;
    }

    public static class Step {
        private int id;
        private String shortDescription;
        private String description;
        private String videoUrl;
        private String thumbnailUrl;
    }

    public static class Ingredient {
        private float quantity;
        private String measure;
        private String ingredient;
    }
}
