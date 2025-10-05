package leetcode_problems.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class DesignFoodRatingSystem_2353 {

    // {food, cuisine}; -> cuisineByFood
    // {cuisine, Map<food, rating>}} -> foodsByCuisine
    // {cuisine, TreeMap<rating, TreeSet<food>>} -> ratingsByCuisine
    private final Map<String, String> cuisineByFood;
    private final Map<String, Map<String, Integer>> foodsByCuisine;
    private final Map<String, TreeMap<Integer, TreeSet<String>>> ratingsByCuisine;

    // Time complexity: O(nlogn)
    // Space complexity: O(n)
    public DesignFoodRatingSystem_2353(String[] foods, String[] cuisines, int[] ratings) {
        this.cuisineByFood = new HashMap<>();
        this.foodsByCuisine = new HashMap<>();
        this.ratingsByCuisine = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {
            String food = foods[i];
            String cuisine = cuisines[i];
            int rating = ratings[i];
            cuisineByFood.put(food, cuisine);
            foodsByCuisine.computeIfAbsent(cuisine, k -> new HashMap<>()).put(food, rating);
            ratingsByCuisine.computeIfAbsent(cuisine, k -> new TreeMap<>())
                    .computeIfAbsent(rating, k -> new TreeSet<>()).add(food);
        }
    }

    // Time complexity: O(logk)
    // Space complexity: O(k)
    public void changeRating(String food, int newRating) {
        // {food, cuisine} -> cuisineByFood
        String cuisine = cuisineByFood.get(food);
        // {cuisine, Map<food, rating>}} -> foodsByCuisine
        Map<String, Integer> ratingByFood = foodsByCuisine.get(cuisine);
        int oldRating = ratingByFood.get(food);

        // update the old rating
        foodsByCuisine.get(cuisine).put(food, newRating);

        // update the rating in ratingsByCuisine
        // Map<String, TreeMap<Integer, TreeSet<String>>> ratingsByCuisine;
        TreeMap<Integer, TreeSet<String>> ratings = ratingsByCuisine.get(cuisine);

        // Remove the food from old rating first
        ratings.get(oldRating).remove(food);
        if (ratings.get(oldRating).isEmpty()) ratings.remove(oldRating);

        // add to the new rating list
        ratings.computeIfAbsent(newRating, k -> new TreeSet<>()).add(food);
    }

    // Time complexity: O(logk)
    // Space complexity: O(1)
    public String highestRated(String cuisine) {
        // Map<String, TreeMap<Integer, TreeSet<String>>> ratingsByCuisine;
        return ratingsByCuisine.get(cuisine).lastEntry().getValue().first();
    }
}
