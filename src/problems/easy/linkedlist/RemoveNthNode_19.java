package problems.easy.linkedlist;

// todo not done
public class RemoveNthNode_19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;

        ListNode temp = head;
        ListNode dummy = temp;
        int size = 0;
        while(temp != null){
            temp = temp.next;
            size ++;
        }
        temp = head;
        for (int i = 0; i < size - n; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;

        temp = dummy;
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
