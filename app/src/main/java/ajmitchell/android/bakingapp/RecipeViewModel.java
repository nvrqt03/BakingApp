package ajmitchell.android.bakingapp;

import android.content.ClipData;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

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

public class RecipeViewModel extends ViewModel {
    private static final String TAG = "RecipeViewModel";
    // TODO: Implement the ViewModel
    private MutableLiveData<List<Recipe>> mRecipes;
    private RecipeAdapter adapter;
    private BakingApi bakingApi;
    private RecyclerView recyclerView;


}
