package com.example.android.bakingapp.data;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Recipe implements Parcelable {
    private int id;
    private String name;
    public static final Parcelable.Creator<Recipe> CREATOR = new Parcelable.Creator<Recipe>() {
        public Recipe createFromParcel(Parcel in) {
            return new Recipe(in);
        }

        public Recipe[] newArray(int size) {
            return new Recipe[size];
        }
    };
    private List<Ingredient> ingredients;
    private int servings;
    private String recipeImage;
    private List<Step> steps;

    private Recipe(Parcel in) {
        id = in.readInt();
        name = in.readString();
        ingredients = in.createTypedArrayList(Ingredient.CREATOR);
        steps = in.createTypedArrayList(Step.CREATOR);
        servings = in.readInt();
        recipeImage = in.readString();
    }

    public String getName() {
        return name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int i) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeTypedList(ingredients);
        dest.writeTypedList(steps);
        dest.writeInt(servings);
        dest.writeString(recipeImage);
    }

    public List<Step> getSteps() {
        return steps;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ingredients=" + ingredients +
                ", steps=" + steps +
                ", servings=" + servings +
                ", recipeImage='" + recipeImage + '\'' +
                '}';
    }

    public static class Step implements Parcelable {
        private int id;
        private String shortDescription;
        private String description;
        private String videoUrl;
        private String thumbnailUrl;

        public String getShortDescription() {
            return shortDescription;
        }

        public String getDescription() {
            return description;
        }

        public static final Parcelable.Creator<Step> CREATOR = new Parcelable.Creator<Step>() {
            public Step createFromParcel(Parcel in) {
                return new Step(in);
            }

            public Step[] newArray(int size) {
                return new Step[size];
            }
        };

        private Step(Parcel in) {
            id = in.readInt();
            shortDescription = in.readString();
            description = in.readString();
            videoUrl = in.readString();
            thumbnailUrl = in.readString();
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int i) {
            dest.writeInt(id);
            dest.writeString(shortDescription);
            dest.writeString(description);
            dest.writeString(videoUrl);
            dest.writeString(thumbnailUrl);
        }

        @Override
        public String toString() {
            return "Step{" +
                    "id=" + id +
                    ", shortDescription='" + shortDescription + '\'' +
                    ", description='" + description + '\'' +
                    ", videoUrl='" + videoUrl + '\'' +
                    ", thumbnailUrl='" + thumbnailUrl + '\'' +
                    '}';
        }
    }

    public static class Ingredient implements Parcelable {
        private float quantity;
        private String measure;
        private String ingredient;

        public static final Parcelable.Creator<Ingredient> CREATOR = new Parcelable.Creator<Ingredient>() {
            public Ingredient createFromParcel(Parcel in) {
                return new Ingredient(in);
            }

            public Ingredient[] newArray(int size) {
                return new Ingredient[size];
            }
        };

        private Ingredient(Parcel in) {
            quantity = in.readFloat();
            measure = in.readString();
            ingredient = in.readString();
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int i) {
            dest.writeFloat(quantity);
            dest.writeString(measure);
            dest.writeString(ingredient);
        }

        @Override
        public String toString() {
            return "Ingredient{" +
                    "quantity=" + quantity +
                    ", measure='" + measure + '\'' +
                    ", ingredient='" + ingredient + '\'' +
                    '}';
        }
    }
}
