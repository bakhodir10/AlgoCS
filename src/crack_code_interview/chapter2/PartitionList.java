package crack_code_interview.chapter2;

@SuppressWarnings("Duplicates")
public class PartitionList {

    // Time complexity: O(n). Space complexity: O(n)
    public ListNode partition(ListNode head, int x) {
        ListNode lesser = new ListNode(-1);
        ListNode greater = new ListNode(-1);
        ListNode pointLesser = lesser;
        ListNode pointGreater = greater;

        while (head != null) {
            if (head.val < x) {
                lesser.next = head;
                lesser = lesser.next;
            } else {
                greater.next = head;
                greater = greater.next;
            }
            head = head.next;
        }

        greater.next = null;
        lesser.next = pointGreater.next;
        return pointLesser.next;
    }
}
