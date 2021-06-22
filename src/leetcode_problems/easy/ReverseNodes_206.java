package leetcode_problems.easy;

public class ReverseNodes_206 {

    // Iterative approach. One-time pass
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

    // Iterative approach. One-time pass
    public ListNode reverseList2(ListNode head) {
        ListNode current = head;
        ListNode following = head;
        ListNode prev = null;

        while (current != null) {
            following = following.next;
            current.next = prev;
            prev = current;
            current = following;
        }
        return head;
    }

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
