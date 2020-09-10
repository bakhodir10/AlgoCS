package problems.medium;

import java.util.*;

public class TopKFrequentWords_692 {

    // Time complexity: Worst case O(nlog(n)). Space complexity: O(n)
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> counts = new HashMap<>();

        for (String word : words) counts.put(word, counts.getOrDefault(word, 0) + 1);

        List<String>[] bucket = new ArrayList[words.length];

        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            String key = entry.getKey();
            int val = entry.getValue();
            if (bucket[val] == null) bucket[val] = new ArrayList<>();
            bucket[val].add(key);
        }
        List<String> ans = new ArrayList<>(k);

        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] == null) continue;
            List<String> freq = bucket[i];
            Collections.sort(freq);
            for (String s : freq) {
                if (k == 0) return ans;
                ans.add(s);
                k--;
            }
        }
        return ans;
    }

    // Time complexity: O(nlog(k)). Space complexity: O(n)
    public List<String> topKFrequent2(String[] words, int k) {
        Map<String, Integer> counts = new HashMap<>();

        for (String word : words) counts.put(word, counts.getOrDefault(word, 0) + 1);

        Queue<Pair> pQ = new PriorityQueue<>(k, (p1, p2) -> p1.count - p2.count != 0
                ? p1.count - p2.count
                : p2.word.compareTo(p1.word));

        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            pQ.offer(new Pair(entry.getKey(), entry.getValue()));
            if (pQ.size() > k) pQ.poll();
        }

        List<String> ans = new ArrayList<>(k);

        while (!pQ.isEmpty()) ans.add(pQ.poll().word);

        Collections.reverse(ans);
        return ans;
    }

    private class Pair {
        private String word;
        private int count;

        public Pair(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
}
