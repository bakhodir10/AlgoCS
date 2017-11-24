package problems.easy.linkedlist;

 // todo not node
public class LinkedListCycle_142 {

    public ListNode dectectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null) {
            slow = slow.next; // todo there is a NullPointer Exception
            if(fast.next.next != null){
                fast = fast.next.next;
            }
            if(fast == slow){
                fast = head;
                while(fast != slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
