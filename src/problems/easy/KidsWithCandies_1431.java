package problems.easy;

import java.util.ArrayList;
import java.util.List;

public class KidsWithCandies_1431 {

    // Time complexity: O(n). Space complexity: O(n);
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        if (candies.length == 0) return new ArrayList<>();

        List<Boolean> greatestCandies = new ArrayList<>();
        int maxCandy = Integer.MIN_VALUE;

        for (int candy : candies) maxCandy = Math.max(maxCandy, candy);
        for (int candy : candies) greatestCandies.add(candy + extraCandies >= maxCandy);
        
        return greatestCandies;
    }
}
