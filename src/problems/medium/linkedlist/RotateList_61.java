package problems.medium.linkedlist;

// todo not done
public class RotateList_61 {

    public ListNode rotateRight(ListNode head, int k) {
        ListNode temp = head;
        int i = 0;
        while (i < k) {
            temp = temp.next;
        }
        return null;
    }

    private class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
