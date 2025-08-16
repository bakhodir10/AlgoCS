package leetcode_problems.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LinkedListRandomNode_382 {

    public static class ListNode {
        int val;
        ListNode next;
    }

    // Using Reservoir algorithm each element has a probability of being picked i/n times.
    // Reservoir algorithm is when the input is large, streams or size is unknown

    private final ListNode head;
    private final Random rand;

    // Time complexity: O(1)
    // Space complexity: O(1)
    public LinkedListRandomNode_382(ListNode head) {
        this.head = head;
        this.rand = new Random();
    }

    // Time complexity: O(n)
    // Space complexity: O(1)
    public int getRandom() {
        int size = 0, val = -1;
        ListNode curr = head;
        while(curr != null) {
            size++;
            if(rand.nextInt(size) == 0) {
                val = curr.val;
            }
            curr = curr.next;
        }
        return val;
    }

    /*
     Using memoization. This approach is good when the size is small or definite.

        private final List<ListNode> nodes;

        // Time complexity: O(n)
        // Space complexity: O(n)
        public LinkedListRandomNode_382(ListNode head) {
            this.nodes = new ArrayList<>();
            while(head != null) {
                nodes.add(head);
                head = head.next;
            }
        }

        // Time complexity: O(1)
        // Space complexity: O(1)
        public int getRandom() {
            int idx = (int)(Math.random() * nodes.size());
            return nodes.get(idx).val;
        }
    */
}
