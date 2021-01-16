package ajmitchell.android.bakingapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import ajmitchell.android.bakingapp.R;
import ajmitchell.android.bakingapp.RecipeDetailActivity;
import ajmitchell.android.bakingapp.models.Recipe;
import ajmitchell.android.bakingapp.utils.Constants;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder> {

    private List<Recipe> recipeList = new ArrayList<>();
    private boolean mTwoPane = false;
    private Context mContext;
    private Recipe recipe;

    public RecipeAdapter(List<Recipe> recipeList, Context context) {
        this.recipeList = recipeList;
        this.mContext = context;
    }

    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recipe_item, parent, false);
        return new RecipeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder holder, int position) {
        Recipe items = holder.recipe = recipeList.get(position);
        holder.recipeName.setText(items.getName());
        holder.servings.setText(Constants.SERVING + String.valueOf(items.getServings()));
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("arrayList", recipe);

                    Context context = view.getContext();
                    Intent intent = new Intent(context, RecipeDetailActivity.class);
                    intent.putExtra("recipes", holder.getAdapterPosition());
                    context.startActivity(intent);
                }
        });
    }

    @Override
    public int getItemCount() {
        if (recipeList == null) {
            return 0;
        }
        return recipeList.size();
    }

    public class RecipeViewHolder extends RecyclerView.ViewHolder {
        View view;
        TextView recipeName;
        TextView servings;
        Recipe recipe;

        public RecipeViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            recipeName = itemView.findViewById(R.id.recipe_name);
            servings = itemView.findViewById(R.id.servings);


        }
    }

    public interface  RecipeItemClickListener {
        void onRecipeItemClick(Recipe recipeItem);
    }

}
