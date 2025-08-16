package leetcode_problems.medium;

public class OddEvenLinkedList_328 {
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    // Time complexity: O(n)
    // Space complexity: O(1)
    public ListNode oddEvenList1(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode odds = head;
        ListNode evens = head.next;
        ListNode evenHead = head.next;

        while(evens != null && evens.next != null) {
            odds.next = odds.next.next;
            odds = odds.next;
            evens.next = evens.next.next;
            evens = evens.next;
        }
        odds.next = evenHead;
        return head;
    }

    // Time complexity: O(n)
    // Space complexity: O(1)
    public ListNode oddEvenList2(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return head;

        int idx = 1;
        ListNode curr = head;
        ListNode odds = new ListNode(-1);
        ListNode headOdds = odds;
        ListNode evens = new ListNode(-1);
        ListNode headEvens = evens;

        while(curr != null) {
            if(idx % 2 == 0) {
                evens.next = curr;
                evens = evens.next;
            } else {
                odds.next = curr;
                odds = odds.next;
            }
            curr = curr.next;
            idx++;
        }

        odds.next = null;
        evens.next = null;
        headEvens = headEvens.next;
        odds.next = headEvens;

        return headOdds.next;
    }
}
