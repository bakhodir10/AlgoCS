package leetcode_problems.medium;

import java.util.*;
import java.util.stream.Collectors;

public class Permutations_46 {

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> subResult = new LinkedList<>();
    Set<Integer> used = new HashSet<>();

    // Time complexity: O(n*n!)
    // Space complexity: O(n)
    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums);
        return result;
    }

    private void backtrack(int[] nums) {
        if(subResult.size() == nums.length) {
            result.add(new LinkedList<>(subResult));
            return;
        }

        for(int i = 0; i < nums.length; i ++) {
            if(used.contains(i)) continue;

            used.add(i);
            subResult.add(nums[i]);

            backtrack(nums);

            subResult.removeLast();
            used.remove(i);
        }
    }

    // Time complexity: O(n*n!)
    // Space complexity: O(n)
    public static List<List<Integer>> permute2(int nums[]) {
        return permuteHelper(nums, 0, new ArrayList<>());
    }

    private static List<List<Integer>> permuteHelper(int[] nums, int start, List<List<Integer>> ans) {
        if (nums.length == 0) {
            ans.add(new ArrayList<>());
            return ans;
        }
        if (start == nums.length - 1) {
            List<Integer> newPermute = Arrays.stream(nums).boxed().collect(Collectors.toList());
            ans.add(newPermute);
        } else {
            for (int i = start; i <= nums.length - 1; i++) {
                swap(nums, i, start);
                permuteHelper(nums, start + 1, ans);
                swap(nums, i, start);
            }
        }
        return ans;
    }

    private static void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
