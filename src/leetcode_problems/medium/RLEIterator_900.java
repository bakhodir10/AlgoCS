package leetcode_problems.medium;

import java.util.LinkedList;
import java.util.Queue;

public class RLEIterator_900 {

    private final Queue<Node> q;

    public RLEIterator_900(int[] encoding) {
        this.q = new LinkedList<>();

        for (int i = 0; i < encoding.length; i += 2) {
            int count = encoding[i];
            int val = encoding[i + 1];

            if (count != 0) q.add(new Node(val, count));
        }
    }

    public int next(int n) {
        int val = -1;

        while (n > 0) {
            if (q.isEmpty()) return -1;

            Node firstNode = q.peek();
            val = firstNode.val;

            if (firstNode.count <= n) {
                n -= firstNode.count;
                q.poll();
            } else {
                int temp = n;
                n -= firstNode.count;
                firstNode.count -= temp;
            }
        }
        return val;
    }

    private static class Node {
        private final int val;
        private int count;

        public Node(int val, int count) {
            this.val = val;
            this.count = count;
        }
    }
}
