package leetcode_problems.medium;

public class MapSumPairs_677 {

    private Node root;

    public MapSumPairs_677() {
        this.root = new Node();
    }

    private class Node {
        private int sum;
        private int val;
        private boolean isWord;
        private final Node[] children;

        public Node() {
            this.sum = 0;
            this.children = new Node[26];
        }
    }

    public void insert(String key, int val) {
        Node curr = this.root;

        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (curr.children[c - 'a'] == null) curr.children[c - 'a'] = new Node();
            curr.children[c - 'a'].sum += val;
            curr = curr.children[c - 'a'];
        }

        if (curr.isWord) updateVal(key, curr.val);

        curr.val = val;
        curr.isWord = true;
    }

    public int sum(String prefix) {
        Node curr = this.root;

        for (char c : prefix.toCharArray()) {
            if (curr.children[c - 'a'] == null) return 0;
            curr = curr.children[c - 'a'];
        }
        return curr.sum;
    }

    private void updateVal(String key, int oldVal) {
        Node curr = this.root;

        for (char c : key.toCharArray()) {
            curr.children[c - 'a'].sum -= oldVal;
            curr = curr.children[c - 'a'];
        }
    }
}
