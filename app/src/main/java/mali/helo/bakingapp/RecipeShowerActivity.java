package mali.helo.bakingapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class RecipeShowerActivity extends AppCompatActivity {
    private boolean mIsDualPane;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_shower);
        View stepContainer =findViewById(R.id.step_navigator_conteiner);
        View detailContainer = findViewById(R.id.detail_conteiner);

        mIsDualPane = detailContainer != null;
    }
}
