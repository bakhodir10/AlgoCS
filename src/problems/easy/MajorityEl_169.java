package problems.easy;

import java.util.HashMap;
import java.util.Map;

public class MajorityEl_169 {
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer m = map.get(nums[i]) == null ? 0 : map.get(nums[i]);
            map.put(nums[i], m + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > nums.length / 2) return entry.getKey();
        }
        return -1;
    }
}
