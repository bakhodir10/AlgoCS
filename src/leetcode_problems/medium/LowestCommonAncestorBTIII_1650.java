package leetcode_problems.medium;

import java.util.HashSet;
import java.util.Set;

public class LowestCommonAncestorBTIII_1650 {

    // Time complexity: O(n). Space complexity: O(n)
    public Node lowestCommonAncestor(Node p, Node q) {
        Set<Node> ancestors = new HashSet<>(); // keep parent of p in Set

        while (p != null) {
            ancestors.add(p);
            p = p.parent;
        }

        while (!ancestors.contains(q)) q = q.parent;
        return q;
    }

    private record Node(int val, Node left, Node right, Node parent) {}
}
