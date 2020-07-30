package com.example.foodie;

public class MealItem {

    private String title, description, ingredients, calories, link;
    private int imageID;

    public MealItem(int imageID, String title, String description, String ingredients, String calories, String link) {
        this.imageID = imageID;
        this.title = title;
        this.description = description;
        this.ingredients = ingredients;
        this.calories = calories;
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }
}
