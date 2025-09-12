package leetcode_problems.hard;

import java.util.Arrays;

public class Candy_135 {

    // Time complexity: O(n^2)
    // Space complexity: O(n)
    public int candy(int[] ratings) {
        int count = 0;
        boolean stillHas = true;
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);

        while (stillHas) {
            stillHas = false;
            for (int i = 0; i < ratings.length; i++) {
                if (i > 0 && ratings[i - 1] < ratings[i] && candies[i - 1] >= candies[i]) {
                    candies[i] = candies[i - 1] + 1;
                    stillHas = true;
                }
                if (i + 1 < ratings.length && ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
                    candies[i] = candies[i] + 1;
                    stillHas = true;
                }
            }
        }

        for (int can : candies) count += can;
        return count;
    }

    // Time complexity: O(n)
    // Space complexity: O(n)
    public int candy2(int[] ratings) {
        int[] left2Right = new int[ratings.length];
        int[] right2Left = new int[ratings.length];
        Arrays.fill(left2Right, 1);
        Arrays.fill(right2Left, 1);

        for(int i = 1; i < ratings.length; i ++) {
            if(ratings[i - 1] < ratings[i]) left2Right[i] = left2Right[i - 1] + 1;
        }
        for(int i = ratings.length - 2; i >= 0; i --) {
            if(ratings[i] > ratings[i + 1]) right2Left[i] = right2Left[i + 1] + 1;
        }

        int max = 0;
        for(int i = 0; i < left2Right.length; i ++) {
            max += Math.max(left2Right[i], right2Left[i]);
        }
        return max;
    }
}
