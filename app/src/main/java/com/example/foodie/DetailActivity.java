package com.example.foodie;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    TextView titleView, descriptionView, ingredientsView, caloriesView, linkView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        setReferences();

        titleView.setText(getIntent().getStringExtra("title"));
        descriptionView.setText(getIntent().getStringExtra("description"));
        ingredientsView.setText(getIntent().getStringExtra("ingredients"));
        caloriesView.setText(getIntent().getStringExtra("calories"));
        linkView.setText(getIntent().getStringExtra("link"));

        Glide.with(this).load(getIntent().getIntExtra("image", 0)).into(imageView);
    }

    private void setReferences() {
        titleView = findViewById(R.id.detail_title);
        descriptionView = findViewById(R.id.detail_description);
        ingredientsView = findViewById(R.id.detail_ingredients);
        caloriesView = findViewById(R.id.detail_calories);
        linkView = findViewById(R.id.detail_link);
        imageView = findViewById(R.id.detail_image);
    }
}