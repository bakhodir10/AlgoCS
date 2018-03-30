package problems.medium;

public class RemoveNthNode_19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;

        ListNode temp = new ListNode(Integer.MIN_VALUE);
        temp.next = head;
        ListNode dummy = temp;
        int size = 0;
        while(temp.next != null){
            temp = temp.next;
            size ++;
        }

        temp = dummy;
        for (int i = 0; i < size - n; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;

        temp = dummy.next;
        return temp;
    }

    private class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
