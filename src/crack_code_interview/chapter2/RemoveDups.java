package crack_code_interview.chapter2;

import java.util.HashSet;
import java.util.Set;

/*
    Remove Dups: Write code to remove duplicates from an unsorted linked list.
    How would you solve this problem if a temporary buffer is not allowed?
 */

public class RemoveDups {

    // Time complexity: O(n). Space complexity: O(1)
    public static ListNode removeDuplicates(ListNode node) {
        if (node == null) return null;
        Set<Integer> values = new HashSet<>();
        values.add(node.val);
        ListNode dummy = node;

        while (node.next != null) {
            if (values.contains(node.next.val)) {
                node.next = node.next.next;
            }
            values.add(node.next.val);
            node = node.next;
        }

        return dummy;
    }
}
