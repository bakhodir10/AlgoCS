package leetcode_problems.medium;

public class WateringPlants_5201 {

    // Time complexity: O(n). Space complexity: O(1)
    public int wateringPlants(int[] plants, int capacity) {
        int currCap = capacity;
        int steps = 0;

        for (int i = 0; i < plants.length; i++) {
            if (currCap >= plants[i]) { // there is enough capacity
                currCap -= plants[i]; // water the plant
                steps++;  // 1 step ahead
            } else { // need to refill
                steps += i; // to go back to river
                currCap = capacity; // refilled
                steps += i + 1; // to come back to the i
                currCap -= plants[i]; // water the plant
            }
        }
        return steps; // return total steps
    }
}
