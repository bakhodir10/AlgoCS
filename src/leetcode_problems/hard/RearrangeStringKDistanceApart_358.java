package leetcode_problems.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class RearrangeStringKDistanceApart_358 {

    public record Pair(char c, int count) {
    }

    // Time complexity: O(nlogn)
    // Space complexity: O(n)
    public String rearrangeString(String s, int k) {
        if (k <= 0) return s;

        PriorityQueue<Pair> p = new PriorityQueue<>((a, b) -> {
            if (a.count != b.count) return b.count - a.count;
            else return a.c - b.c;
        });
        int[] counts = new int[26];

        for (char c : s.toCharArray()) counts[c - 'a']++;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0) p.offer(new Pair((char) (i + 'a'), counts[i]));
        }

        StringBuilder sb = new StringBuilder();
        while (!p.isEmpty()) {
            List<Pair> temp = new ArrayList<>();

            for (int i = 0; i < k; i++) {
                if (sb.length() == s.length()) return sb.toString();
                if (p.isEmpty()) return "";
                Pair pair = p.poll();
                sb.append(pair.c);
                if (pair.count > 1) temp.add(new Pair(pair.c, pair.count - 1));
            }
            for (Pair pair : temp) p.offer(pair);
        }
        return sb.toString();
    }
}
