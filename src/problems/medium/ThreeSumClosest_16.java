package problems.medium;

import java.util.Arrays;

public class ThreeSumClosest_16 {

    // Time complexity: O(n^2). Space complexity: O(1)
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int closest = Integer.MAX_VALUE;
        int sum = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            int l = i + 1;
            int r = nums.length - 1;

            while (l < r) {
                int currSum = nums[i] + nums[l] + nums[r];
                int currClosest = Math.abs(target - currSum);

                if (currClosest == 0) return currSum;

                if (currClosest < closest) {
                    closest = currClosest;
                    sum = currSum;
                }

                if (currSum < target) l++;
                else r--;
            }
        }
        return sum;
    }
}
