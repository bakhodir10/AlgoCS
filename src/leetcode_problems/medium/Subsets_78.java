package leetcode_problems.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subsets_78 {

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> subResult = new LinkedList<>();

    // Time complexity: O(2^n)
    // Space complexity: O(n)
    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0);
        return result;
    }

    private void dfs(int[] nums, int i) {
        if (i >= nums.length) {
            result.add(new LinkedList<>(subResult));
            return;
        }

        subResult.add(nums[i]);
        dfs(nums, i + 1);
        subResult.removeLast();
        dfs(nums, i + 1);
    }

    // Time complexity: O(2^n)
    // Space complexity: O(n)
    public List<List<Integer>> subsets2(int[] nums) {
        backtrack(nums, 0);
        return result;
    }

    private void backtrack(int[] nums, int first) {
        result.add(new LinkedList<>(subResult));

        for(int i = first; i < nums.length; i ++) {
            subResult.add(nums[i]);
            backtrack(nums, i + 1);
            subResult.removeLast();
        }
    }
}
