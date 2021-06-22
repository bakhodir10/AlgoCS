package leetcode_problems.easy;

public class RemoveDuplicate_83 {

    public ListNode removeDuplicate(ListNode head) {
        ListNode temp = new ListNode(Integer.MIN_VALUE);
        temp.next = head;
        ListNode dummy = temp;
        int lastElem = Integer.MIN_VALUE;

        while (temp.next != null) {
            if (temp.next.val == lastElem) {
                temp.next = temp.next.next;
            } else {
                lastElem = temp.next.val;
                temp = temp.next;
            }
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
