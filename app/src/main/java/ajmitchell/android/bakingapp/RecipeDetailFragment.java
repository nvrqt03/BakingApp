package ajmitchell.android.bakingapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;
import ajmitchell.android.bakingapp.models.Recipe;

public class RecipeDetailFragment extends Fragment {


    public Recipe mRecipe;
    private List<Recipe> recipeList = new ArrayList<>();

    public RecipeDetailFragment() {

    }

    public static RecipeDetailFragment newInstance(int selectedRecipe) {
        RecipeDetailFragment fragment = new RecipeDetailFragment();
        Bundle args = new Bundle();
        args.putInt("recipe", selectedRecipe);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey("recipe")) {
            mRecipe = recipeList.get(getArguments().getInt("recipe"));
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_recipe_detail, container, false);

        if (mRecipe != null) {
            ((TextView) rootView.findViewById(R.id.recipe_name)).setText(mRecipe.getName());
            ((TextView) rootView.findViewById(R.id.recipe_ingredients)).setText(mRecipe.getIngredients().toString());
            ((TextView) rootView.findViewById(R.id.long_description)).setText(mRecipe.describeContents());
        }
        return rootView;
    }

}
