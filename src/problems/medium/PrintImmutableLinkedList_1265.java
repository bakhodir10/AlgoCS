package problems.medium;

import java.util.Stack;

public class PrintImmutableLinkedList_1265 {

    // Time complexity: O(n). Space complexity: O(1)
    public void printLinkedListInReverse1(ImmutableListNode head) {
        if (head == null) return;
        printLinkedListInReverse1(head.getNext());
        head.printValue();
    }

    // Time complexity: O(n). Space complexity: O(n)
    public void printLinkedListInReverse2(ImmutableListNode head) {
        Stack<ImmutableListNode> st = new Stack<>();

        while (head != null) {
            st.add(head);
            head = head.getNext();
        }

        while (!st.isEmpty()) st.pop().printValue();
    }

    interface ImmutableListNode {
        void printValue(); // print the value of this node.

        ImmutableListNode getNext(); // return the next node.
    }
}
