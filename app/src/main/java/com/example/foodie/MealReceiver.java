package com.example.foodie;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import java.util.Random;

public class MealReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String intentAction = intent.getAction();
        if (intentAction != null) {
            switch(intentAction) {
                case "com.example.I_AM_HOME":
                mealToCook(context);
            }
        }
    }

    private void mealToCook(Context context) {
        String TITLE_EXTRA = "title";
        String DESCRIPTION_EXTRA = "description";
        String INGREDIENTS_EXTRA = "ingredients";
        String CALORIES_EXTRA = "calories";
        String LINK_EXTRA = "link";
        String IMAGE_EXTRA = "image";

        Random rand = new Random();
        MealItem mealItem = MainActivity.mealData.get(rand.nextInt(MainActivity.mealData.size()));
        Intent detailIntent = new Intent(context, DetailActivity.class);
        detailIntent.putExtra(TITLE_EXTRA, mealItem.getTitle());
        detailIntent.putExtra(DESCRIPTION_EXTRA, mealItem.getDescription());
        detailIntent.putExtra(INGREDIENTS_EXTRA, mealItem.getIngredients());
        detailIntent.putExtra(CALORIES_EXTRA, mealItem.getCalories());
        detailIntent.putExtra(LINK_EXTRA, mealItem.getLink());
        detailIntent.putExtra(IMAGE_EXTRA, mealItem.getImageID());
        context.startActivity(detailIntent);

        Toast.makeText(context, "Happy Cooking " + mealItem.getTitle(), Toast.LENGTH_LONG).show();
    }
}
