package ajmitchell.android.bakingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import ajmitchell.android.bakingapp.adapters.RecipeAdapter;
import ajmitchell.android.bakingapp.databinding.ActivityMainBinding;
import ajmitchell.android.bakingapp.models.Recipe;
import ajmitchell.android.bakingapp.network.BakingApi;

public class MainActivity extends AppCompatActivity  {

    ActivityMainBinding mBinding;
    public static final String TAG = "MainActivity.class";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        if (savedInstanceState == null) {

            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.recipeFragment, RecipeFragment.class, null)
                    .commit();
        }

    }

}