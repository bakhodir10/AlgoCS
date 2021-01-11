package problems.medium;

public class SwappingNodesLinkedList_1721 {

    // Time complexity: O(n). Space complexity: O(1)
    public ListNode swapNodes(ListNode head, int k) {
        ListNode firstK = head;
        ListNode lastK = head;

        for (int i = 0; i < k - 1; i++) firstK = firstK.next;

        ListNode fast = firstK.next;
        while (fast != null) {
            lastK = lastK.next;
            fast = fast.next;
        }

        ListNode newNode;
        if (lastK != null) {
            int val = firstK.val;
            firstK.val = lastK.val;
            lastK.val = val;
        }
        return head;
    }

    private static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
