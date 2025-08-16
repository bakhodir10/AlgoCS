package neetcode.two_pointers;

import java.util.*;

public class ThreeSum {

    // Brute fore.
    // Time complexity: O(n^3).
    // Space complexity: O(1)
    public List<List<Integer>> threeSum1(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        return new ArrayList<>(res);
    }

    // Two pointers.
    // Time complexity: O(n^2).
    // Space complexity: O(1)
    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i - 1] || nums[i] > 0) continue;

            int l = i + 1, r = nums.length - 1;
            while(l < r) {
                while(l < r &&  nums[l] + nums[r] + nums[i] < 0) l++;
                while(l < r && nums[l] + nums[r] + nums[i] > 0) r--;
                if(nums[i] + nums[l] + nums[r] == 0 && l != r) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while(l < r && nums[l] == nums[l + 1]) l++;
                    l++;
                }
            }
        }
        return res;
    }
}
