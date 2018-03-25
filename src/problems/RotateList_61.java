package problems;

public class RotateList_61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        ListNode newNode, tail;
        newNode = tail = head;
        int size = 1;
        while (tail.next != null) {
            tail = tail.next;
            size++;
        }
        k %= size;
        tail.next = head;

        if (k != 0) {
            for (int i = 0; i < size - k; i++) {
                tail = tail.next;
            }
        }

        newNode = tail.next;
        tail.next = null;
        return newNode;
    }

    private class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
