package crack_code_interview.chapter2;

/*
    Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list.
 */

public class ReturnKthLast {

    // Time complexity: O(n). Space complexity: O(1);
    public ListNode returnKthLast(ListNode node, int k) {
        ListNode p1 = node;
        ListNode p2 = node;
        int i = 0;
        while (i < k && p1 != null) {
            p1 = p1.next;
            i++;
        }
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}
