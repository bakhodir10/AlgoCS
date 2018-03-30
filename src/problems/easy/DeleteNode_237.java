package problems.easy;

public class DeleteNode_237 {

    public void delete(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
