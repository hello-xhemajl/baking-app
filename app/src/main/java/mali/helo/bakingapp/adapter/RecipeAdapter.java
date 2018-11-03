package mali.helo.bakingapp.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import mali.helo.bakingapp.R;
import mali.helo.bakingapp.model.Recipe;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeVh> {
     public static class RecipeVh extends RecyclerView.ViewHolder{
        @BindView(R.id.name_text_view) TextView mNameTextView;
        @BindView(R.id.servings_text_view) TextView mServingsTextView;

        OnRecipeListener mListener;

        public RecipeVh(@NonNull View itemView, OnRecipeListener listener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mListener = listener;
        }

        public interface OnRecipeListener{
            void onRecipeClick(int position);
        }
    }

    private RecipeVh.OnRecipeListener mOnRecipeListener;
    private List<Recipe> mRecipes;

    public RecipeAdapter(RecipeVh.OnRecipeListener onRecipeListener) {
        mOnRecipeListener = onRecipeListener;
    }

    @NonNull
    @Override
    public RecipeVh onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View recipeView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_recipe, viewGroup, false);

        return new RecipeVh(recipeView, mOnRecipeListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeVh recipeVh, int position) {
        Recipe recipe = mRecipes.get(position);
        recipeVh.mNameTextView.setText(recipe.getName());
        recipeVh.mServingsTextView.setText(recipe.getServings());
    }

    @Override
    public int getItemCount() {
        return mRecipes != null ? mRecipes.size(): 0;
    }

    public void setRecipes(List<Recipe> recipes){
        mRecipes = recipes;
        notifyDataSetChanged();
    }
}
