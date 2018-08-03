package problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations_46 {
    public static void main(String[] args) {
    }

    public static List<List<Integer>> permute(int nums[]) {
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
