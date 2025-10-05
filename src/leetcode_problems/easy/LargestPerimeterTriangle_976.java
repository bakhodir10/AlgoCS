package leetcode_problems.easy;

import java.util.Arrays;

public class LargestPerimeterTriangle_976 {

    // Time complexity: O(nlogn)
    // Space complexity: O(n for sorting)
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);

        for(int i = nums.length - 1; i >= 2; i --) {
            if(nums[i] < nums[i - 1] + nums[i - 2]) {
                return nums[i] + nums[i - 1] + nums[i - 2];
            }
        }
        return 0;
    }
}
