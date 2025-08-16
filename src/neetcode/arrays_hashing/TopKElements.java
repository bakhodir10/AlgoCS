package neetcode.arrays_hashing;
import java.util.*;

public class TopKElements {
    record Pair(int num, int count){}

    // Time complexity: O(nlogn)
    // Space complexity: O(n)
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        int i = 0;
        Map<Integer, Integer> mapByNumbers = new HashMap<>();
        List<Pair> counts = new ArrayList<>();

        for(int num: nums) mapByNumbers.put(num, mapByNumbers.getOrDefault(num, 0) + 1);

        for(Map.Entry<Integer, Integer> entry: mapByNumbers.entrySet()) {
            counts.add(new Pair(entry.getValue(), entry.getKey()));
        }

        counts.sort((e1, e2) -> e2.count - e1.count);
        while(k > 0) res[--k] = counts.get(i++).num;
        return res;
    }

    // Time complexity: O(nlogk)
    // Space complexity: O(n)
    public int[] topKFrequent2(int[] nums, int k) {
        int[] res = new int[k];
        PriorityQueue<Pair> pQ = new PriorityQueue<Pair>((e2, e1) -> e2.count - e1.count);
        Map<Integer, Integer> counts = new HashMap<>();

        for(int num: nums) counts.put(num, counts.getOrDefault(num, 0) + 1);
        for(Map.Entry<Integer, Integer> entry: counts.entrySet()) {
            pQ.add(new Pair(entry.getValue(), entry.getKey()));
            if(pQ.size() > k) pQ.poll();
        }
        while(k > 0 && !pQ.isEmpty()) res[--k] = pQ.poll().num;
        return res;
    }

    // Counting sorting
    // Time complexity: O(n)
    // Space complexity: O(n)
    public int[] topKFrequent3(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> counts = new HashMap<>();
        List<Integer>[] freqs = new ArrayList[nums.length + 1];

        for(int i = 0; i < freqs.length; i++) freqs[i] = new ArrayList<>();
        for(int num: nums) counts.put(num, counts.getOrDefault(num, 0) + 1);

        for(Map.Entry<Integer, Integer> entry: counts.entrySet()) {
            freqs[entry.getValue()].add(entry.getKey());
        }

        for(int i = freqs.length - 1; i > 0 && k > 0; i--) {
            List<Integer> list = freqs[i];
            for(int j = 0; j < list.size() && k > 0; j++) res[--k] = list.get(j);
        }
        return res;
    }
}
