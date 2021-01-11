package problems.easy;

public class MergeTwoSorted_21 {

    // Approach 1. Create a new node for each node
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode newNode = new ListNode();
        ListNode head = newNode;

        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                if (l1.val > l2.val) {
                    newNode.next = new ListNode(l2.val);
                    l2 = l2.next;
                } else {
                    newNode.next = new ListNode(l1.val);
                    l1 = l1.next;
                }
            } else if (l1 != null) {
                newNode.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                newNode.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            newNode = newNode.next;
        }
        return head.next;
    }

    // Approach 2. Change pointers
    public ListNode mergeTwoLists2(ListNode n1, ListNode n2) {
        ListNode result = new ListNode();
        ListNode head = result;

        while (n1 != null && n2 != null) {
            if (n1.val < n2.val) {
                result.next = n1;
                n1 = n1.next;
            } else {
                result.next = n2;
                n2 = n2.next;
            }
            result = result.next;
        }
        if (n1 != null) result.next = n1;
        if (n2 != null) result.next = n2;
        return head.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }
    }
}
