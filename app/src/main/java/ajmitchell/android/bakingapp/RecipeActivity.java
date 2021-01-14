package ajmitchell.android.bakingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class RecipeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        if (savedInstanceState == null) {
            int selectedRecipe = getIntent().getIntExtra("recipe", 0);
            RecipeDetailFragment fragment = RecipeDetailFragment.newInstance(selectedRecipe);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.recipe_detail_container, fragment)
                    .commit();
        }
    }
}