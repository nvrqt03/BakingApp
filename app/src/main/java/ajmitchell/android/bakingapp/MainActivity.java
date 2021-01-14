package ajmitchell.android.bakingapp;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import ajmitchell.android.bakingapp.adapters.RecipeAdapter;
import ajmitchell.android.bakingapp.models.Recipe;
import ajmitchell.android.bakingapp.network.BakingApi;
import ajmitchell.android.bakingapp.network.RetrofitClient;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Retrofit;


public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity.class";

    private boolean mTwoPane = false;
    private RecyclerView recyclerView;
    private RecipeAdapter adapter;
    private List<Recipe> recipeList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get recipe list as a recyclerView
        recyclerView = findViewById(R.id.recipe_list);

        if (findViewById(R.id.recipe_detail_container) != null) {
            mTwoPane = true;
        }

        Retrofit retrofit = RetrofitClient.getInstance();
        BakingApi bakingApi = retrofit.create(BakingApi.class);

        Observable<List<Recipe>> observable = bakingApi.getRecipes();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Recipe>>() {
                    @Override
                    public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@io.reactivex.rxjava3.annotations.NonNull List<Recipe> recipes) {
                        displayData(recipes);
                    }

                    @Override
                    public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {
                        Log.e(TAG, "onError: ", e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }

    private void displayData(List<Recipe> recipes) {
        adapter = new RecipeAdapter(recipes, getApplicationContext());
        recyclerView.setAdapter(adapter);

    }
}