package ajmitchell.android.bakingapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import ajmitchell.android.bakingapp.models.Ingredient;
import ajmitchell.android.bakingapp.models.Recipe;



public class RecipeDetailFragment extends Fragment {


    public Recipe mRecipe;
    private final static String TAG = "RecipeDetailFragment";
    private String recipeName;
    //private List<Ingredient> ingredients;

    public RecipeDetailFragment() {

    }

    public static RecipeDetailFragment newInstance(Recipe selectedRecipe) {
        RecipeDetailFragment fragment = new RecipeDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("recipe", selectedRecipe);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null && getArguments().containsKey("recipe")) {
            mRecipe = getArguments().getParcelable("recipe");
            recipeName = mRecipe.getName();
            //ingredients = mRecipe.getIngredients();
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.recipe_detail, container, false);

        if (mRecipe != null) {
            ((TextView) rootView.findViewById(R.id.recipe_detail)).setText(recipeName);
//            ((TextView) rootView.findViewById(R.id.recipe_detail)).setText((CharSequence) ingredients);
//            ((TextView) rootView.findViewById(R.id.long_description)).setText(mRecipe.describeContents());
        } else {
            Log.e(TAG, "onCreateView: mRecipe is null", null);
        }
        return rootView;
    }

}
