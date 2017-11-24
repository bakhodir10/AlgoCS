package problems.easy.linkedlist;

// todo not done
public class ReverseNodes_206 {

    public ListNode reverse(ListNode head) {

        return null;

        /*
            3 0 9 7 2
            2 0 9 7 3
            2 7 9 0 3
         */
    }

    public void add() {
        ListNode head = new ListNode(5);
        ListNode node = new ListNode(5);
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(9);
        ListNode temp = head;
        head.next = node;
        head = head.next;
        head.next = node1;
        head = head.next;
        head.next = node2;
        head = temp;
        reverse(head);
    }

    public void iterate(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        ReverseNodes_206 list = new ReverseNodes_206();
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
