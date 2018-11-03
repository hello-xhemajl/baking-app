package mali.helo.bakingapp;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;

import java.util.List;

import mali.helo.bakingapp.model.Recipe;


public class SharedViewModel extends AndroidViewModel{
    private MutableLiveData<List<Recipe>> mRecipes;
    private MutableLiveData<Recipe> mSelectedRecipe;

    private NetHelper mVolley;

    public SharedViewModel(@NonNull Application application) {
        super(application);
        mVolley = NetHelper.getInstance(application);
    }

    public LiveData<List<Recipe>> getRecipes(){
        if(mRecipes == null){
            mRecipes = new MutableLiveData<>();
            requestRecipes();
        }

        return mRecipes;
    }

    public LiveData<Recipe> getSelectedRecipe(){
        if(mSelectedRecipe == null){
            mSelectedRecipe = new MutableLiveData<>();
        }

        return mSelectedRecipe;
    }

    public void selectRecipe(Recipe recipe){
        mSelectedRecipe.setValue(recipe);
    }

    private void requestRecipes(){
        JsonArrayRequest recipesRequest = new JsonArrayRequest(Request.Method.GET,
                "http://d17h27t6h515a5.cloudfront.net/topher/2017/May/59121517_baking/baking.json",
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        List<Recipe> recipes = APIUtils.extractRecipes(response);
                        mRecipes.setValue(recipes);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("helomali", error.getMessage());
                mRecipes = null;
            }
        });

        // Make a request to get recipes form internet
        mVolley.addToRequestQueue(recipesRequest);
    }
}
