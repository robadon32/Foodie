package com.example.foodie;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static int FAB_REQUEST_CODE = 1;
    MealReceiver mealReceiver;
    MealItemAdapter mealAdapter;
    protected static ArrayList<MealItem> mealData;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mealReceiver = new MealReceiver();
        int gridColumnCount = getResources().getInteger(R.integer.grid_layout_count);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(this, gridColumnCount));

        mealData = new ArrayList<>();

        mealAdapter = new MealItemAdapter(this, mealData);
        recyclerView.setAdapter(mealAdapter);

        loadMealData();

        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAddMealItemActivity();
            }
        });

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.I_AM_HOME");
        this.registerReceiver(mealReceiver, intentFilter);
    }

    private void startAddMealItemActivity() {
        Intent intent = new Intent(this, AddItemActivity.class);
        startActivityForResult(intent, FAB_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == FAB_REQUEST_CODE && resultCode == RESULT_OK) {
            assert data != null;
            String mealItemTitle = data.getStringExtra(AddItemActivity.MEAL_TITLE_EXTRA);
            String mealItemDescription = data.getStringExtra(AddItemActivity.MEAL_DESCRIPTION_EXTRA);
            String mealItemIngredients = data.getStringExtra(AddItemActivity.MEAL_INGREDIENTS_EXTRA);
            String mealItemCalories = data.getStringExtra(AddItemActivity.MEAL_CALORIES_EXTRA);
            String mealItemLink = data.getStringExtra(AddItemActivity.MEAL_LINK_EXTRA);

            mealData.add(new MealItem(R.drawable.chicken_parm, mealItemTitle, mealItemDescription,
                    mealItemIngredients, mealItemCalories, mealItemLink));
            mealAdapter.notifyDataSetChanged();
        }
    }

    private void loadMealData() {
        TypedArray arrImage = getResources().obtainTypedArray(R.array.meal_images);
        String[] arrTitle = getResources().getStringArray(R.array.meal_titles);
        String[] arrDescription = getResources().getStringArray(R.array.meal_description);
        String[] arrIngredients = getResources().getStringArray(R.array.meal_ingredients);
        String[] arrCalories = getResources().getStringArray(R.array.meal_calories);
        String[] arrLinks = getResources().getStringArray(R.array.meal_links);

        mealData.clear();

        for(int i = 0; i < arrTitle.length; i++) {
         mealData.add(new MealItem(arrImage.getResourceId(i,0), arrTitle[i], arrDescription[i], arrIngredients[i],
                        arrCalories[i], arrLinks[i]));
        }
        arrImage.recycle();
        mealAdapter.notifyDataSetChanged();
    }

    public void addNewMeal(View view) {

    }

    @Override
    protected void onDestroy() {
        this.unregisterReceiver(mealReceiver);
        super.onDestroy();
    }
}