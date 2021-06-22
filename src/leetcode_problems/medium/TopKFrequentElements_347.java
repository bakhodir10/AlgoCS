package leetcode_problems.medium;

import java.util.*;

public class TopKFrequentElements_347 {

    // Time complexity: O(nlog(k)). Space complexity: O(n)
    public int[] topKFrequent1(int nums[], int k) {
        int[] ans = new int[k];
        Map<Integer, Integer> counts = new HashMap<>();

        for (int num : nums) counts.put(num, counts.getOrDefault(num, 0) + 1);

        Queue<int[]> topK = new PriorityQueue<>(k, (a, b) -> a[1] - b[1]);
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            topK.offer(new int[]{entry.getKey(), entry.getValue()});
            if (topK.size() > k) topK.poll();
        }
        while (!topK.isEmpty()) ans[--k] = topK.poll()[0];
        return ans;
    }

    // Time complexity: O(n). Space complexity: O(n). Using bucket sort algorithm
    public int[] topKFrequent2(int[] nums, int k) {
        int[] ans = new int[k];
        List<Integer>[] frequencies = new List[nums.length];
        Map<Integer, Integer> counts = new HashMap<>();

        for (int num : nums) counts.put(num, counts.getOrDefault(num, 0) + 1);

        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();
            if (frequencies[freq] == null) frequencies[freq] = new LinkedList<>();
            frequencies[freq].add(num);
        }

        for (int i = frequencies.length - 1; i >= 0; i--) {
            List<Integer> list = frequencies[i];
            for (int num : list) {
                if (k == 0) return ans;
                else ans[--k] = num;
            }
        }
        return ans;
    }
}
