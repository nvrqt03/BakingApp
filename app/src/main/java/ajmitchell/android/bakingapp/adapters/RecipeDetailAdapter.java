package ajmitchell.android.bakingapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ajmitchell.android.bakingapp.R;
import ajmitchell.android.bakingapp.models.Recipe;
import ajmitchell.android.bakingapp.models.Step;

public class RecipeDetailAdapter extends RecyclerView.Adapter<RecipeDetailAdapter.StepViewHolder> {

    private List<Step> recipeSteps;

    public RecipeDetailAdapter(List<Step> recipeSteps) {
        this.recipeSteps = recipeSteps;
    }

    @NonNull
    @Override
    public StepViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recipe_step_item, parent, false);
        return new RecipeDetailAdapter.StepViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StepViewHolder holder, int position) {
        Step items = holder.step = recipeSteps.get(position);
        holder.stepItem.setText(items.getShortDescription());
    }

    @Override
    public int getItemCount() {
        if (recipeSteps == null) {
            return 0;
        } else {
            return recipeSteps.size();
        }
    }


    public class StepViewHolder extends RecyclerView.ViewHolder {

        TextView stepItem;
        Step step;
        public StepViewHolder(@NonNull View itemView) {
            super(itemView);

            stepItem = itemView.findViewById(R.id.description);
        }
    }
}
