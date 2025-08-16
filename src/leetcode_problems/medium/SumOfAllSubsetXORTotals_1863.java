package leetcode_problems.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SumOfAllSubsetXORTotals_1863 {

    List<List<Integer>> list = new ArrayList<>();
    List<Integer> subList = new LinkedList<>();

    // Time complexity: O(n*2^n)
    // Space complexity: O(n)
    public int subsetXORSum(int[] nums) {
        backtrack(nums, 0);
        int res = 0;
        for(List<Integer> subList: list) {
            int xor = 0;
            for(int val: subList) xor ^= val;
            res += xor;
        }
        return res;
    }

    private void backtrack(int[] nums, int pos) {
        list.add(new LinkedList<>(subList));

        for(int i = pos; i < nums.length; i ++) {
            subList.add(nums[i]);
            backtrack(nums, i + 1);
            subList.removeLast();
        }
    }
}
