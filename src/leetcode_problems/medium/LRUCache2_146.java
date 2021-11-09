package leetcode_problems.medium;

import java.util.HashMap;
import java.util.Map;

public class LRUCache2_146 {

    // Double linked node that helps to remove/add any node in O(1)
    private class DLinkedNode {
        int key;
        int val;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode(int key, int val) {
            this.key = key;
            this.val = val;
        }

        public DLinkedNode() {
        }
    }

    /*
        Always adds the new node right after head;
        h -> 2
        Add a new node with value 1 to the list
        h -> 1 -> 2
     */
    private void addNode(DLinkedNode node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    /*
        Remove an existing from the linked list
        h -> 1 - > 2 -> 3
        Remove an existing node with the value 2
        h -> 1 -> 3
     */
    private void removeNode(DLinkedNode node) {
        DLinkedNode prev = node.prev;
        DLinkedNode next = node.next;

        next.prev = prev;
        prev.next = next;
    }

    /*
        Move a specific node to the head
        h -> 1 -> 2 -> 3
        Move the node with value 2 to the head
        h -> 2 -> 1 -> 3
     */
    private void moveNodeToHead(DLinkedNode node) {
        removeNode(node);
        addNode(node);
    }

    /*
        Remove the node from tail
        h -> 2 -> 1 -> 3
        Remove the node with value 3
     */
    private DLinkedNode removeTail() {
        DLinkedNode prev = tail.prev;
        removeNode(prev);
        return prev;
    }

    private int size;
    private final int capacity;
    private final DLinkedNode head;
    private final DLinkedNode tail;
    private final Map<Integer, DLinkedNode> cache = new HashMap<>();

    public LRUCache2_146(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.head = new DLinkedNode();
        // head.next = null
        this.tail = new DLinkedNode();
        // tail.pre = null;

        this.head.next = tail;
        this.tail.prev = head;
    }

    // Time complexity: O(1)
    public int get(int key) {
        DLinkedNode node = cache.get(key);

        if (node == null) return -1;

        moveNodeToHead(node);
        return node.val;
    }

    // Time complexity: O(1)
    public void put(int key, int value) {

        if (cache.containsKey(key)) {
            DLinkedNode existingNode = cache.get(key);
            existingNode.val = value;
            moveNodeToHead(existingNode);
        } else {
            DLinkedNode newNode = new DLinkedNode(key, value);
            cache.put(key, newNode);
            addNode(newNode);

            size++;

            if (size > capacity) {
                DLinkedNode tail = removeTail();
                cache.remove(tail.key);
                size--;
            }
        }
    }
}
