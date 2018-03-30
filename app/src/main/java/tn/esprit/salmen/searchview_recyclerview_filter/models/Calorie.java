package tn.esprit.salmen.searchview_recyclerview_filter.models;

/**
 * Created by Salmen on 30/03/2018.
 */

public class Calorie {

    private String name;
    private int calories;
    private int imageRes;

    public Calorie(String name, int calories, int imageRes) {
        this.name = name;
        this.calories = calories;
        this.imageRes = imageRes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getImageRes() {
        return imageRes;
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
    }
}
