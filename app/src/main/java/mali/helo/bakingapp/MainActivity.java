package mali.helo.bakingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;

import java.util.List;

import mali.helo.bakingapp.model.Recipe;

public class MainActivity extends AppCompatActivity {

    private NetHelper mVolley;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mVolley = NetHelper.getInstance(this);

        JsonArrayRequest recipesRequest = new JsonArrayRequest(Request.Method.GET,
                "https://d17h27t6h515a5.cloudfront.net/topher/2017/May/59121517_baking/baking.json",
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        List<Recipe> recipes = APIUtils.extractRecipes(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("helomali", error.getMessage());
            }
        });

        mVolley.addToRequestQueue(recipesRequest);
    }
}
