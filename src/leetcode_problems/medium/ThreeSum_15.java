package leetcode_problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15 {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {

            if (i == 0 || nums[i] != nums[i - 1]) {
                int looking = 0 - nums[i];
                int l = i + 1;
                int r = nums.length - 1;

                while (l < r) {
                    if (nums[l] + nums[r] == looking) {
                        ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        l++;
                        r--;
                    } else if (nums[l] + nums[r] > looking) {
                        r--;
                    } else {
                        l++;
                    }
                }
            }
        }
        return ans;
    }
}
