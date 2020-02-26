package problems.easy;

import java.util.ArrayList;
import java.util.List;

public class PalindromeLinkedList_234 {

    // approach 1. Using additional memory O(n). Time complexity O(n)
    public boolean isPalindrome(ListNode head) {
        List<Integer> numbers = new ArrayList<>();
        // first, store all numbers in a list
        while (head != null) {
            numbers.add(head.val);
            head = head.next;
        }
        int i = 0;
        // start comparing left and right cells of the list till it reaches the middle
        while (i < numbers.size() / 2) {
            if (!numbers.get(i).equals(numbers.get(numbers.size() - 1 - i))) return false;
            i++;
        }
        return true;
    }

    // approach 2. Using additional memory O(1). Time complexity O(n)
    public boolean isPalindrome2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        // Find a middle node by fast and slow pointers
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = head;
        // reverse the second half of the head
        ListNode prevNode = null;
        while (slow != null) {
            ListNode nextNode = slow.next;
            slow.next = prevNode;
            prevNode = slow;
            slow = nextNode;
        }
        slow = prevNode;
        // check for palindrome
        while (slow != null) {
            if (fast.val != slow.val) return false;
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}