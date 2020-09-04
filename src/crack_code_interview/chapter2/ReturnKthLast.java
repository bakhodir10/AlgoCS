package crack_code_interview.chapter2;

/*
    Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list.
 */

public class ReturnKthLast {

    // Time complexity: O(n). Space complexity: O(1);
    public ListNode returnKthLast(ListNode node, int k) {
        ListNode fast = node;
        ListNode slow = node;

        while (k-- > 0) fast = fast.next;

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
