package lintcode.leetcode_premiums;

import java.util.Stack;

public class PrintImmutableLinkedList_3674 {
    public static class ImmutableListNode {
        int val;
        ImmutableListNode next;

        ImmutableListNode getNext() {
            return next;
        }

        void printValue() {
            System.out.print(val);
        }
    }

    // Time complexity: O(n)
    // Space complexity: O(n)
    public void printInReverse1(ImmutableListNode head) {
        // Using head.printValue() to print the value of current node.
        // Using head.getNext() to get the next node.
        // --- write your code here ---

        Stack<ImmutableListNode> st = new Stack<>();
        while(head != null) {
            st.push(head);
            head = head.getNext();
        }
        while(!st.isEmpty()) st.pop().printValue();
    }

    // Time complexity: O(n^2)
    // Space complexity: O(1)
    public void printInReverse2(ImmutableListNode head) {
        // Using head.printValue() to print the value of current node.
        // Using head.getNext() to get the next node.
        // --- write your code here ---
        int length = getLength(head);
        for(int i = length - 1; i >= 0; i--) {
            ImmutableListNode curr = head;
            for (int j = 0; j < i; j++) curr = curr.getNext();
            curr.printValue();
        }
    }

    // Time complexity: O(n)
    // Space complexity: O(logn). Because of recursive stack call
    public void printInReverse3(ImmutableListNode head) {
        // Using head.printValue() to print the value of current node.
        // Using head.getNext() to get the next node.
        // --- write your code here ---
        int len = getLength(head);
        helper(head, len);
    }

    private void helper(ImmutableListNode head, int len) {
        if(len == 0) return;
        if(len == 1) {
            head.printValue();
            return;
        }
        ImmutableListNode midNode = head;
        int mid = len / 2;
        for(int i = 0; i < mid; i ++) midNode = midNode.getNext();
        helper(midNode, len - mid);
        helper(head, mid);
    }
    private int getLength(ImmutableListNode head) {
        ImmutableListNode curr = head;
        int len = 0;

        while(curr != null) {
            len++;
            curr = curr.getNext();
        }
        return len;
    }

}
