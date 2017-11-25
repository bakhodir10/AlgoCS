package problems.easy.linkedlist;

public class ReverseNodes_206 {

    public ListNode reverseList(ListNode head) {
        if (head == null) return null;

        ListNode newHead = new ListNode(head.val);
        head = head.next;
        while (head != null) {
            ListNode newNode = new ListNode(head.val);
            newNode.next = newHead;
            newHead = newNode;
            head = head.next;
        }
        return newHead;
    }

    private class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
