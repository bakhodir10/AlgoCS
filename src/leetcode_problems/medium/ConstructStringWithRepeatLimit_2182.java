package leetcode_problems.medium;

import java.util.PriorityQueue;

public class ConstructStringWithRepeatLimit_2182 {

    public static class Pair {
        private final char c;
        int count;

        public Pair(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }

    // n -> the length of the string S
    // k -> number of unique characters. 26 characters in max
    // Time complexity: O(nlogk)
    // Space complexity: O(k)
    public String repeatLimitedString(String s, int repeatLimit) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.c - a.c);
        int[] counts = new int[26];

        for(char c: s.toCharArray()) counts[c - 'a']++;
        for(int i = 0; i < counts.length; i ++) {
            if(counts[i] > 0) pq.add(new Pair((char) (i + 'a'), counts[i]));
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            Pair first = pq.poll();
            if(!sb.isEmpty() && sb.charAt(sb.length() - 1) == first.c) continue;

            int block = Math.min(repeatLimit, first.count);
            sb.append(String.valueOf(first.c).repeat(block));

            // append the next single lower character
            if(first.count > repeatLimit && !pq.isEmpty()) {
                Pair second = pq.poll();
                second.count--;
                sb.append(second.c);
                if(second.count > 0) pq.offer(second);
            }
            first.count -= block;
            if(first.count > 0) pq.offer(first);
        }
        return sb.toString();
    }
}
