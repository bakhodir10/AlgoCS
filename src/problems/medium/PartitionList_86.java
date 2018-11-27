package problems.medium;

@SuppressWarnings("Duplicates")
public class PartitionList_86 {

    public ListNode partition(ListNode head, int x) {
        ListNode lesser = new ListNode(-1);
        ListNode greater = new ListNode(-1);
        ListNode pointLesser = lesser;
        ListNode pointGreater = greater;

        while (head != null) {
            if (head.val < x) {
                lesser.next = head;
                lesser = lesser.next;
            } else {
                greater.next = head;
                greater = greater.next;
            }
            head = head.next;
        }

        greater.next = null;
        lesser.next = pointGreater.next;
        return pointLesser.next;
    }

    private class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
