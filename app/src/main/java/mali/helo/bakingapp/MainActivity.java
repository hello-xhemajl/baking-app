package mali.helo.bakingapp;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import mali.helo.bakingapp.adapter.RecipeAdapter;
import mali.helo.bakingapp.model.Recipe;

public class MainActivity extends AppCompatActivity implements RecipeAdapter.RecipeVh.OnRecipeListener {
    @BindView(R.id.recipe_recycler_view)
    RecyclerView mRecipesView;
    RecipeAdapter mAdapter;
    List<Recipe> mRecipes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mAdapter = new RecipeAdapter(this);
        mRecipesView.setAdapter(mAdapter);

        SharedViewModel model = ViewModelProviders.of(this).get(SharedViewModel.class);
        model.getRecipes().observe(this, new Observer<List<Recipe>>() {
            @Override
            public void onChanged(@Nullable List<Recipe> recipes) {
                mRecipes = recipes;
                mAdapter.setRecipes(mRecipes);
            }
        });
    }

    @Override
    public void onRecipeClick(int position) {
        Recipe recipe = mRecipes.get(position);
    }
}
