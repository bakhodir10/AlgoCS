package leetcode_problems.medium;

import java.util.PriorityQueue;

public class ReorganizeString_767 {

    private static class Pair {
        final char c;
        int count;

        public Pair(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }

    // n-> String s length, k is array count and PriorityQueue size which is 26.
    // Time complexity: O(nlogk) -> O(nlog26) ~= O(n)
    // Space complexity: O(n)
    public String reorganizeString(String s) {
        int[] counts = new int[26];
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Pair> pq = new PriorityQueue<>(26, (a, b) -> b.count - a.count);

        for (char c : s.toCharArray()) counts[c - 'a']++; // O(n)

        // O(k * log(k)) = O(26 * log26) = O(1)
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] != 0) pq.offer(new Pair((char) (i + 'a'), counts[i]));
        }

        while (!pq.isEmpty()) { // O(n)
            Pair first = pq.poll(); // O(log(k)) = O(log26) = O(1)

            if (sb.isEmpty() || first.c != sb.charAt(sb.length() - 1)) {
                sb.append(first.c);
                first.count--;
                if (first.count > 0) pq.offer(first); // O(log(k)) = O(log26) = O(1)
            } else {
                if (pq.isEmpty()) return "";

                Pair second = pq.poll(); // O(log(k)) = O(log26) = O(1)
                sb.append(second.c);
                second.count--;
                if (second.count > 0) pq.offer(second); // O(log(k)) = O(log26) = O(1)
                pq.offer(first); // O(log(k)) = O(log26) = O(1)
            }
        }
        return sb.toString(); // O(n)
    }
}
