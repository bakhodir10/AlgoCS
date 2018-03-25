package problems.linkedlist;

public class LinkedCycle_141 {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode newNode = reverse(head);
        if (newNode == head) return true;
        return false;
    }

    public static ListNode reverse(ListNode node) {
        ListNode prevNode = null;
        ListNode currentNode = node;

        while (currentNode != null) {
            ListNode nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }
        return prevNode;
    }

    private class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
}
