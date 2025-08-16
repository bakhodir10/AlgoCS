package leetcode_problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubsetsII_90 {

    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> subResult = new LinkedList<>();

    // Time complexity: O(n*2^n)
    // Space complexity: O(n)
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, 0);
        return result;
    }

    private void backtrack(int[] nums,int idx) {
        result.add(new LinkedList<>(subResult));

        for(int i = idx; i < nums.length; i ++) {
            if(i != idx && nums[i] == nums[i - 1]) continue;
            subResult.add(nums[i]);
            backtrack(nums, i + 1);
            subResult.removeLast();
        }
    }
}
