package leetcode_problems.easy;

public class ReverseLinkedList_206 {

    // Iterative approach. One-time pass. Time complexity: O(n). Memory complexity: O(n)
    public ListNode reverseList1(ListNode head) {
        ListNode pivot = head;
        ListNode frontier = null;

        while (pivot != null && pivot.next != null) {
            frontier = pivot.next;
            pivot.next = pivot.next.next;
            frontier.next = head;
            head = frontier;
        }
        return head;
    }

    // Iterative approach. One-time pass. Time complexity: O(n). Memory complexity: O(n)
    public ListNode reverseList2(ListNode head) {
        ListNode following = head;
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            following = following.next;
            curr.next = prev;
            prev = curr;
            curr = following;
        }
        return prev;
    }

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
