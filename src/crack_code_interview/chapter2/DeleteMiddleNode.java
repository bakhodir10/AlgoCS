package crack_code_interview.chapter2;

/*
    Delete Middle Node: Implement an algorithm to delete a node in the middle (i.e., any node but
    the first and last node, not necessarily the exact middle) of a singly linked list, given only access to
    that node.
    EXAMPLE
    Input: the node c from the linked list a - >b- >c - >d - >e- >f
    Result: nothing is returned, but the new linked list looks like a - >b- >d - >e- >f
 */
public class DeleteMiddleNode {

    // Time complexity: O(n). Space complexity: O(1)
    public ListNode deleteMiddleNode(ListNode node) {
        if (node == null) return null;
        ListNode fast = node;
        ListNode slow = node;
        ListNode prev = null;
        ListNode head = node;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (prev != null && prev.next != null) {
            prev.next = prev.next.next;
        }
        return head;
    }
}
