package com.example.foodie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

public class AddItemActivity extends AppCompatActivity implements TextWatcher {

    protected static String MEAL_TITLE_EXTRA = "title";
    protected static String MEAL_DESCRIPTION_EXTRA = "description";
    protected static String MEAL_INGREDIENTS_EXTRA = "ingredients";
    protected static String MEAL_CALORIES_EXTRA = "calories";
    protected static String MEAL_LINK_EXTRA = "link";

    EditText editTitle, editDescription, editIngredients, editCalories, editLink;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        setReferences();
    }

    private void setReferences() {
        editTitle = findViewById(R.id.edit_text_title);
        editDescription = findViewById(R.id.edit_text_description);
        editIngredients = findViewById(R.id.edit_text_ingredients);
        editCalories = findViewById(R.id.edit_text_calories);
        editLink = findViewById(R.id.edit_text_link);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    public void addMeal(View view) {
        Intent addMealIntent = new Intent();
        addMealIntent.putExtra(MEAL_TITLE_EXTRA, editTitle.getText().toString());
        addMealIntent.putExtra(MEAL_DESCRIPTION_EXTRA, editTitle.getText().toString());
        addMealIntent.putExtra(MEAL_INGREDIENTS_EXTRA, editTitle.getText().toString());
        addMealIntent.putExtra(MEAL_CALORIES_EXTRA, editTitle.getText().toString());
        addMealIntent.putExtra(MEAL_LINK_EXTRA, editTitle.getText().toString());
        setResult(RESULT_OK, addMealIntent);
        finish();
    }
}