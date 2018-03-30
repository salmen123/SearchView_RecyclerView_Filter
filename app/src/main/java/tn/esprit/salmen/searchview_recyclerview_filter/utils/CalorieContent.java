package tn.esprit.salmen.searchview_recyclerview_filter.utils;

import java.util.ArrayList;
import java.util.List;

import tn.esprit.salmen.searchview_recyclerview_filter.R;
import tn.esprit.salmen.searchview_recyclerview_filter.models.Calorie;

/**
 * Created by Salmen on 30/03/2018.
 */

public class CalorieContent {

    public static ArrayList<Calorie> getCalories()
    {
        ArrayList<Calorie> calories = new ArrayList<>();

        calories.add(new Calorie("Apple", 81,R.drawable.apple));
        calories.add(new Calorie("Avocado", 306, R.drawable.avocado));
        calories.add(new Calorie("Blackberries", 37, R.drawable.blackberries));
        calories.add(new Calorie("Cherries", 52, R.drawable.cherries));
        calories.add(new Calorie("Kiwi", 46, R.drawable.kiwi));
        calories.add(new Calorie("Lemon", 22, R.drawable.lemon));
        calories.add(new Calorie("Mango", 135, R.drawable.mango));
        calories.add(new Calorie("Peach", 37, R.drawable.peach));
        calories.add(new Calorie("Plum", 37, R.drawable.plum));
        calories.add(new Calorie("Cabbage", 18, R.drawable.cabbage));
        calories.add(new Calorie("Capsicum", 15, R.drawable.capsicum));
        calories.add(new Calorie("Carrots", 30, R.drawable.carrots));
        calories.add(new Calorie("Mushrooms", 13, R.drawable.mushroom));
        calories.add(new Calorie("Potatoes", 75, R.drawable.potato));
        calories.add(new Calorie("Onions", 64, R.drawable.onions));
        calories.add(new Calorie("Celery", 7, R.drawable.celery));
        calories.add(new Calorie("Beetroot", 28, R.drawable.beetroot));

        return calories;
    }

}
