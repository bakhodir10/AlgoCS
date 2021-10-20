package leetcode_problems.easy;

import java.util.Stack;

public class ConvertBinaryNumber_1290 {

    // Time complexity: O(n). Space complexity: O(n)
    public int getDecimalValue(ListNode head) {
        int k = 0;
        int dec = 0;
        Stack<Integer> st = new Stack<>();

        while (head != null) {
            st.push(head.val);
            head = head.next;
        }

        while (!st.isEmpty()) dec += st.pop() * Math.pow(2, k++);

        return dec;
    }

    public static class ListNode {
        private int val;
        private ListNode next;
    }
}
