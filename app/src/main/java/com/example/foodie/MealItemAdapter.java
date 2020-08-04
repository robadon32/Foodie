package com.example.foodie;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MealItemAdapter extends RecyclerView.Adapter<MealItemAdapter.ViewHolder> {

    private static String TAG = "MainActivity";
    private ArrayList<MealItem> mealItemData;
    private Context context;

    public MealItemAdapter(Context context, ArrayList<MealItem> mealItemData) {
        this.context = context;
        this.mealItemData = mealItemData;
    }

    @NonNull
    @Override
    public MealItemAdapter.ViewHolder onCreateViewHolder(
            ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MealItemAdapter.ViewHolder holder, int position) {
        MealItem currMealItem = mealItemData.get(position);
        holder.bindTo(currMealItem);
    }

    @Override
    public int getItemCount() {
        return mealItemData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener, View.OnLongClickListener {

        private TextView titleView, calorieView;
        private ImageView mealView;

        public ViewHolder(View itemView) {
            super(itemView);

            mealView = itemView.findViewById(R.id.list_item_image);
            titleView = itemView.findViewById(R.id.list_item_title);
            calorieView = itemView.findViewById(R.id.list_item_calories);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);

        }

        public void bindTo(MealItem currMealItem) {
            Log.d(TAG, currMealItem.getTitle() + " " + currMealItem.getCalories());
            Glide.with(context).load(currMealItem.getImageID()).into(mealView);
            titleView.setText(currMealItem.getTitle());
            calorieView.setText(currMealItem.getCalories());
        }

        @Override
        public void onClick(View v) {
            String TITLE_EXTRA = "title";
            String DESCRIPTION_EXTRA = "description";
            String INGREDIENTS_EXTRA = "ingredients";
            String CALORIES_EXTRA = "calories";
            String LINK_EXTRA = "link";
            String IMAGE_EXTRA = "image";

            MealItem currMealItem = mealItemData.get(getBindingAdapterPosition());
            Intent detailIntent = new Intent(context, DetailActivity.class);
            detailIntent.putExtra(TITLE_EXTRA, currMealItem.getTitle());
            detailIntent.putExtra(DESCRIPTION_EXTRA, currMealItem.getDescription());
            detailIntent.putExtra(INGREDIENTS_EXTRA, currMealItem.getIngredients());
            detailIntent.putExtra(CALORIES_EXTRA, currMealItem.getCalories());
            detailIntent.putExtra(LINK_EXTRA, currMealItem.getLink());
            detailIntent.putExtra(IMAGE_EXTRA, currMealItem.getImageID());
            context.startActivity(detailIntent);

        }

        @Override
        public boolean onLongClick(View v) {
            mealItemData.remove(getBindingAdapterPosition());
            notifyItemChanged(getBindingAdapterPosition());
            notifyDataSetChanged();
            return true;
        }
    }

}
