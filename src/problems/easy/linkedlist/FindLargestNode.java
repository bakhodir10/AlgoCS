package problems.easy.linkedlist;

/*
Write an algorithm to fi nd the largest item in an unsorted singly linked list with cells containing integers.
 */

public class FindLargestNode {

    public ListNode find(ListNode top) {
        if (top == null) throw new NullPointerException();

        ListNode max = new ListNode(top.val, null);

        top = top.next;
        while (top != null) {
            if (top.val > max.val) max = top;
            top = top.next;
        }
        return max;
    }

    private class ListNode {
        private Integer val;
        private ListNode next;

        public ListNode(Integer val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
