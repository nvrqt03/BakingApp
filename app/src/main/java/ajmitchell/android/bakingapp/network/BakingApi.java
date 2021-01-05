package ajmitchell.android.bakingapp.network;

import java.util.List;

import ajmitchell.android.bakingapp.models.Ingredient;
import ajmitchell.android.bakingapp.models.Recipe;
import ajmitchell.android.bakingapp.models.Step;
import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface BakingApi {
    @GET("topher/2017/May/59121517_baking/baking.json")
    Observable<List<Recipe>> getRecipes();

    @GET("topher/2017/May/59121517_baking/baking.json")
    Observable<List<Ingredient>> getIngredients();

    @GET("topher/2017/May/59121517_baking/baking.json")
    Observable<List<Step>> getSteps();
}
