package mali.helo.bakingapp;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import mali.helo.bakingapp.model.Ingredient;
import mali.helo.bakingapp.model.Recipe;
import mali.helo.bakingapp.model.Step;

/** Helper class for parsing BakingApp API responses */
public class APIUtils {
    public static final String TAG = APIUtils.class.getSimpleName();

    public static List<Recipe> extractRecipes(JSONArray recipesArray){
        List<Recipe> recipes = new ArrayList<>();
        try {
            for (int i = 0; i < recipesArray.length(); i++) {
                JSONObject recipeObject = recipesArray.getJSONObject(i);
                int id = recipeObject.getInt("id");
                String name = recipeObject.getString("name");
                int servings = recipeObject.getInt("servings");
                String image = recipeObject.getString("image");
                List<Ingredient> ingredients = extractIngredients(recipeObject.getJSONArray("ingredients"));
                List<Step> steps = extractSteps(recipeObject.getJSONArray("steps"));

                recipes.add(new Recipe(name, ingredients, servings, steps, image, id));
            }
        } catch (JSONException e){
            Log.e(TAG, "Exception while parsing recipe :" + e.getMessage());
        }

        return recipes;
    }

    private static List<Ingredient> extractIngredients(JSONArray ingredientsArray){
        List<Ingredient> ingredients = new ArrayList<>();
        try {
            for (int i = 0; i < ingredientsArray.length(); i++) {
                JSONObject ingredientObject = ingredientsArray.getJSONObject(i);
                double quantity = ingredientObject.getDouble("quantity");
                String measure = ingredientObject.getString("measure");
                String ingredient = ingredientObject.getString("ingredient");

                ingredients.add(new Ingredient(quantity, measure, ingredient));
            }
        } catch (JSONException e){
            Log.e(TAG, "Exception while parsing ingredient: " + e.getMessage());
        }

        return ingredients;
    }

    private static List<Step> extractSteps(JSONArray stepsArray){
        List<Step> steps = new ArrayList<>();
        try {
            for (int i = 0; i < stepsArray.length(); i++) {
                JSONObject stepObject = stepsArray.getJSONObject(i);
                int id = stepObject.getInt("id");
                String shortDescription = stepObject.getString("shortDescription");
                String description = stepObject.getString("description");
                String video = stepObject.getString("videoURL");
                String thumbnail = stepObject.getString("thumbnailURL");

                steps.add(new Step(description, shortDescription, video, thumbnail, id));
            }
        } catch (JSONException e){
            Log.e(TAG, "Exception while parsing step: " + e.getMessage());
        }

        return steps;
    }

}
