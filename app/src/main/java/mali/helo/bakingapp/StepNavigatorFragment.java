package mali.helo.bakingapp;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import mali.helo.bakingapp.model.Recipe;

public class StepNavigatorFragment extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedViewModel sharedViewModel = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);
        //sharedViewModel.selectRecipe();
    }
}
