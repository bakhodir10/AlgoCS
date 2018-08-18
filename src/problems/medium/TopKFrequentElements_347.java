package problems.medium;

import java.util.*;

public class TopKFrequentElements_347 {

    public static List<Integer> topKFrequent(int nums[], int k) {

        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> counts = new HashMap<>();

        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Pair> topK = new PriorityQueue<>((o1, o2) -> o2.count - o1.count);
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            topK.offer(new Pair(entry.getKey(), entry.getValue()));
        }

        while (k > 0 && !topK.isEmpty()) {
            ans.add(topK.poll().val);
            k--;
        }
        return ans;
    }

    private static class Pair {

        int val;
        int count;

        public Pair(int val, int count) {
            this.val = val;
            this.count = count;
        }
    }
}
