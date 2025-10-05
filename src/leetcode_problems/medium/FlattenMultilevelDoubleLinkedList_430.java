package leetcode_problems.medium;

import java.util.ArrayList;
import java.util.List;

public class FlattenMultilevelDoubleLinkedList_430 {

    private class Node {
        Node prev;
        Node next;
        Node child;
    }

    List<Node> nodes = new ArrayList<>();

    public Node flatten(Node head) {
        if (head == null) return null;

        Node dummy = head;
        dfs(head);
        Node prev;
        head.prev = null;
        head.child = null;

        for (int i = 1; i < nodes.size(); i++) {
            head.next = nodes.get(i);
            prev = head;
            head = head.next;
            head.prev = prev;
            head.child = null;
        }
        return dummy;
    }

    private void dfs(Node head) {
        if (head == null) return;

        nodes.add(head);
        if (head.child != null) dfs(head.child);
        if (head.next != null) dfs(head.next);
    }
}