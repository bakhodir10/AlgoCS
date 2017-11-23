package problems.easy.linkedlist;

public class RemoveAllNodes_203 {

    public ListNode remove(ListNode head, int val) {
        ListNode temp = new ListNode(Integer.MIN_VALUE);
        temp.next = head;
        ListNode dummy = temp;
        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
            } else temp = temp.next;
        }
        head = dummy.next;
        return head;
    }

    private class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
