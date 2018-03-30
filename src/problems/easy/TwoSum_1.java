package problems.easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum_1 {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numbers = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numbers.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            boolean exist = numbers.containsKey(target - nums[i]);
            if (exist) {
                int index = numbers.get(target - nums[i]);
                if (i != index) return new int[]{i, index};
            }
        }
        return new int[]{-1, -1};
    }
}