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

    public String doControlBreak() {
        return null;
    }

    public String getAllMeals() {
        String result = "";
        for (Meal item : mealList) {
            result += item + "\n";
        }
        return result;
    }

    public String searchByName(String name) {
        String result = "";
        for (Meal item : mealList) {
            // Uppercase for case insensitivity
            if (item.getItem().contains(name)) {
                result += item + "\n";
            }
        }

        return result.isBlank() ? "No matches found" : result;
    }

    public String searchByType(MealType mealType) {
        String result = "";
        for (Meal item : mealList) {
            if (item.getMealType() == mealType) {
                result += item + "\n";
            }
        }

        return result.isBlank() ? "No matches found" : result;
    }
}
