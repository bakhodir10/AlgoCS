package leetcode_problems.medium;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK_560 {

    // Time complexity O(n). Memory complexity O(n)
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> cache = new HashMap<>();

        cache.put(0, 1);

        for (int num : nums) {
            sum += num;
            if (cache.containsKey(sum - k)) count += cache.get(sum - k);
            cache.put(sum, cache.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
