package problems.easy.linkedlist;

// todo not done
public class RemoveAllLinkedList_203 {

    public ListNode removeElements(ListNode head, int val) {
        ListNode temp = new ListNode(Integer.MIN_VALUE);
        temp.next = head;
        ListNode dummy = temp;
        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
                head = dummy.next;
            }
            temp = temp.next;
        }
        return head;
    }

    public void add(){
        ListNode node = new ListNode(6);
        ListNode node1 = new ListNode(-16);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(0);
        ListNode head = new ListNode(94);
        head.next = node;
        head.val = node.val;
        head = node;
//        head.next = node1;
//        head.val = node1.val;
//        head = node1;
//        head.next = node2;
//        head.val = node2.val;
//        head = node2;
//        head.next = node3;
//        head.val = node3.val;
//        head = node3;
//        delete(head, 6);
        iterate(head);
    }

    public void iterate(ListNode head) {
        ListNode temp = head;
        while (temp.next != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        RemoveAllLinkedList_203 list = new RemoveAllLinkedList_203();
        list.add();
    }

    private class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
