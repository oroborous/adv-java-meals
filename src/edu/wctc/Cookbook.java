package edu.wctc;

import java.util.ArrayList;
import java.util.List;

public class Cookbook {

    // Hold all the meals that are read in from the file
    private List<Meal> mealList = new ArrayList<>();

    public void addMeal(String mealTypeStr, String mealNameStr, String caloriesStr) {
        MealType mealType;

        try {
            mealType = MealType.valueOf(mealTypeStr.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println(String.format("Meal Creation Error: Invalid meal type %s. Defaulted to Dinner.", mealTypeStr));
            mealType = MealType.DINNER;
        }


        int calories;

        try {
            calories = Integer.parseInt(caloriesStr);
        } catch (NumberFormatException nfe) {
            System.out.println(String.format("Meal Creation Error: Invalid calories %s. Defaulted to 100.", caloriesStr));
            calories = 100;
        }

        mealList.add(new Meal(mealType, mealNameStr, calories));
    }

    public List<Meal> getMeals() {
        return mealList;
    }

    public void printAllMeals() {
        for (Meal item : mealList) {
            System.out.println(item);
        }
    }

    public void printByNameSearch(String s) {
        // Maybe add a message if no match found?
        for (Meal item : mealList) {
            // Uppercase for case insensitivity
            if (item.getItem().contains(s)) {
                System.out.println(item);
            }
        }
    }

    public void printMealsByType(MealType mealType) {
        for (Meal item : mealList) {
            if (item.getMealType() == mealType) {
                System.out.println(item);
            }
        }
    }
}
