package mali.helo.bakingapp.model;

import java.util.List;

/** Represents a cooking recipe */
public class Recipe {
    private String mName;
    private List<Ingredient> mIngredients;
    private int mServings;
    private List<Step> mSteps;
    private String mImage;
    private int mId;

    public Recipe(String name, List<Ingredient> ingredients, int servings, List<Step> steps, String image, int id) {
        mName = name;
        mIngredients = ingredients;
        mServings = servings;
        mSteps = steps;
        mImage = image;
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public List<Ingredient> getIngredients() {
        return mIngredients;
    }

    public int getServings() {
        return mServings;
    }

    public List<Step> getSteps() {
        return mSteps;
    }

    public String getImage() {
        return mImage;
    }
}
