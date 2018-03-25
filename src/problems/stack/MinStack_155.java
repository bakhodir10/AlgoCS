package problems.stack;

public class MinStack_155 {
    private ListNode root;

    public void push(int x) {
        if (root == null) root = new ListNode(x);
        else {
            ListNode newNode = new ListNode(x);
            newNode.next = root;
            root = newNode;
        }
    }

    public void pop() {
        if (root != null) root = root.next;
    }

    public int top() {
        return root.val;
    }

    public int getMin() {
        if (root == null) throw new NullPointerException();
        int min = Integer.MAX_VALUE;
        ListNode node = root;
        while (node != null) {
            if (node.val < min) min = node.val;
            node = node.next;
        }
        return min;
    }

    private class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
