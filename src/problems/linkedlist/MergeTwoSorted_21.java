package problems.linkedlist;

public class MergeTwoSorted_21 {

    public ListNode mergeTwoLists(ListNode n1, ListNode n2) {
        if (n1 == null && n2 == null) return null;
        if (n1 == null) return n2;
        if (n2 == null) return n1;

        ListNode result = new ListNode(Integer.MIN_VALUE);

        while (n1 != null && n2 != null) {
            if (n1.val < n2.val) {
                result.next = n1;
                n1 = n1.next;
                result = result.next;
                result.next = null;
            } else {
                result.next = n2;
                n2 = n2.next;
                result = result.next;
                result.next = null;
            }
        }
        if (n1 != null) result.next = n1;
        if (n2 != null) result.next = n2;
        return result;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
