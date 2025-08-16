package leetcode_problems.medium;

public class ReverseLinkedListII_92 {

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    // Time complexity: O(n)
    // Space complexity: O(1)
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right) return head;

        int idx = 1;
        ListNode nodeBeforeLeftNode = null;
        ListNode leftNode = head;
        ListNode rightNode = head;
        ListNode curr = head;

        while(curr != null && idx <= right) {
            if(idx == left - 1) nodeBeforeLeftNode = curr;
            if(idx == left) leftNode = curr;
            if(idx == right) rightNode = curr;
            idx++;
            curr = curr.next;
        }

        ListNode nodeAfterRightNode = rightNode.next;

        idx = left;
        curr = leftNode;
        ListNode prev = null;
        while(idx <= right) {
            ListNode newNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = newNode;
            idx++;
        }
        ListNode reversedNodeHead = prev;
        ListNode reversedNodeTail = prev;

        while(reversedNodeTail.next != null) reversedNodeTail = reversedNodeTail.next;
        reversedNodeTail.next = nodeAfterRightNode;

        if(nodeBeforeLeftNode != null) nodeBeforeLeftNode.next = reversedNodeHead;
        else head = reversedNodeHead;

        return head;
    }
}
