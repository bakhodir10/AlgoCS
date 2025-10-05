package leetcode_problems.medium;

public class DesignBrowserHistory_1472 {

    private static class Node {
        String val;
        Node prev;
        Node next;

        public Node(String val) {
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }

    private Node curr;
    public DesignBrowserHistory_1472(String homepage) {
        this.curr = new Node(homepage);;
    }

    // O(1)
    public void visit(String url) {
        Node newNode = new Node(url);
        newNode.next = null;
        curr.next = newNode;
        newNode.prev = curr;
        curr = curr.next;
    }

    //  O(min(steps, length))
    public String back(int steps) {
        while(steps > 0 && curr.prev != null) {
            curr = curr.prev;
            steps--;
        }
        return curr.val;
    }

    // O(min(steps, length))
    public String forward(int steps) {
        while(steps > 0 && curr.next != null) {
            curr = curr.next;
            steps--;
        }
        return curr.val;
    }
}
