package leetcode_problems.medium;

import java.util.HashSet;
import java.util.Set;

public class LinkedListComponents_817 {

    public static class ListNode {
        int val;
        ListNode next;
    }

    // Time complexity: O(n)
    // Space complexity: O(n)
    public int numComponents(ListNode head, int[] nums) {
        boolean started = false;
        int count = 0;
        Set<Integer> set = new HashSet<>();

        for(int num: nums) set.add(num);

        while(head != null) {
            if(set.contains(head.val)) {
                if(!started) {
                    count++;
                    started = true;
                }
            } else {
                started = false;
            }
            head = head.next;
        }

        return count;
    }
}
