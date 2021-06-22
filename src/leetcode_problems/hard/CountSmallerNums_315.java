package leetcode_problems.hard;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CountSmallerNums_315 {
    public List<Integer> countSmaller(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) count++;
            }
            nums[i] = count;
        }

        return Arrays.stream(nums).boxed().collect(Collectors.toList());
    }
}
