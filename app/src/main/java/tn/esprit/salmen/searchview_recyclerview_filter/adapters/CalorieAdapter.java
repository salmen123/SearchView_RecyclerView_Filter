package tn.esprit.salmen.searchview_recyclerview_filter.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import tn.esprit.salmen.searchview_recyclerview_filter.R;
import tn.esprit.salmen.searchview_recyclerview_filter.models.Calorie;

/**
 * Created by Salmen on 30/03/2018.
 */

public class CalorieAdapter extends RecyclerView.Adapter<CalorieAdapter.CalorieHolder> {

    private List<Calorie> calories;
    private Context context;

    public CalorieAdapter(List<Calorie> calories, Context context) {
        this.calories = calories;
        this.context = context;
    }

    @Override
    public CalorieHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_calorie, parent, false);
        return new CalorieHolder(view);
    }

    @Override
    public void onBindViewHolder(CalorieHolder holder, final int position) {
        holder.ivCalorie.setImageResource(calories.get(position).getImageRes());
        holder.tvName.setText(calories.get(position).getName());
        holder.tvCalorie.setText("Calories : "+Integer.toString(calories.get(position).getCalories()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "click on " + calories.get(position).getName(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return calories.size();
    }

    public void setFilter(List<Calorie> calorieList)
    {
        calories = new ArrayList<>();
        calories.addAll(calorieList);
        notifyDataSetChanged();
    }

    public class CalorieHolder extends RecyclerView.ViewHolder
    {
        ImageView ivCalorie;
        TextView tvName;
        TextView tvCalorie;

        public CalorieHolder(View itemView) {
            super(itemView);

            ivCalorie = itemView.findViewById(R.id.iv_calorie);
            tvName = itemView.findViewById(R.id.tv_name);
            tvCalorie = itemView.findViewById(R.id.tv_calories);
        }
    }

}
