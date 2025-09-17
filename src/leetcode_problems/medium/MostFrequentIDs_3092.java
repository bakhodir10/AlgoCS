package leetcode_problems.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MostFrequentIDs_3092 {

    // Time complexity: O(nlogn)
    // Space complexity: O(n)
    public long[] mostFrequentIDs(int[] nums, int[] freq) {
        long[] result = new long[nums.length];
        Map<Integer, Long> numWithCount = new HashMap<>();
        TreeMap<Long, Integer> countWithFreq = new TreeMap<>();

        for (int i = 0; i < nums.length; i++) {
            long count = numWithCount.getOrDefault(nums[i], 0L);
            int fre = countWithFreq.getOrDefault(count, 0);

            numWithCount.put(nums[i], count + freq[i]);
            if (count + freq[i] <= 0) numWithCount.remove(nums[i]);

            countWithFreq.put(count, fre - 1);
            if (fre - 1 <= 0) countWithFreq.remove(count);

            countWithFreq.put(count + freq[i], countWithFreq.getOrDefault(count + freq[i], 0) + 1);
            if (count - freq[i] <= 0) countWithFreq.remove(count - freq[i]);

            result[i] = countWithFreq.lastEntry().getKey();
        }
        return result;
    }
}
