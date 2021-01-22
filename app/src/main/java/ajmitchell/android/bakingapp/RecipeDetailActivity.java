package ajmitchell.android.bakingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

import ajmitchell.android.bakingapp.models.Recipe;
import ajmitchell.android.bakingapp.models.Step;

public class RecipeDetailActivity extends AppCompatActivity {

    private boolean mTwoPane = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        if (savedInstanceState == null) {
            Bundle data = getIntent().getExtras();
            Recipe recipe = data.getParcelable("recipes");
            Step step = data.getParcelable("steps");

            RecipeDetailFragment fragment = RecipeDetailFragment.newInstance(recipe);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.recipe_detail_container, fragment)
                    .commit();

            if (mTwoPane = true) {
                StepDetailFragment fragment1 = StepDetailFragment.newInstance(step);
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.recipe_detail_container, fragment1)
                        .commit();
            }
        }
    }
}