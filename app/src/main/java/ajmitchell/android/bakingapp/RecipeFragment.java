package ajmitchell.android.bakingapp;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ajmitchell.android.bakingapp.adapters.RecipeAdapter;
import ajmitchell.android.bakingapp.databinding.RecipeFragmentBinding;
import ajmitchell.android.bakingapp.models.Recipe;
import ajmitchell.android.bakingapp.network.BakingApi;
import ajmitchell.android.bakingapp.network.RetrofitClient;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Retrofit;

public class RecipeFragment extends Fragment implements RecipeAdapter.RecipeItemClickListener {

    private static final String TAG = "RecipeFragment";
    private RecipeViewModel mViewModel;
    private RecipeFragmentBinding mBinding;
    private RecyclerView recyclerView;
    private List<Recipe> recipeList;
    private RecipeAdapter adapter;
    BakingApi bakingApi;
    private RecipeAdapter.RecipeItemClickListener listener;

    public static RecipeFragment newInstance() {
        return new RecipeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.recipe_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(RecipeViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        recyclerView = mBinding.recipeRv;

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecipeAdapter(recipeList, listener);
        recyclerView.setAdapter(adapter);

        Retrofit retrofit = RetrofitClient.getInstance();
        bakingApi = retrofit.create(BakingApi.class);
        getRecipes();

        mBinding.recipeRv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.action_recipeFragment_to_recipeDetailFragment);
            }
        });
    }

    private void getRecipes() {
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
        adapter = new RecipeAdapter(recipes, this);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void onRecipeItemClick(Recipe recipe) {

    }
}