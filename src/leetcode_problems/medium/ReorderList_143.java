package leetcode_problems.medium;

import java.util.ArrayList;
import java.util.List;

public class ReorderList_143 {

    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode temp = head;

        while (temp != null) {
            list.add(temp);
            temp = temp.next;
        }

        int l = 0, r = list.size() - 1;
        ListNode newNode = new ListNode(-1);
        ListNode newHead = newNode;

        while (l <= r) {
            ListNode left = list.get(l);
            ListNode right = list.get(r);

            newNode.next = left;
            newNode = newNode.next;
            newNode.next = right;
            newNode = newNode.next;
            newNode.next = null;

            l++;
            r--;
        }
        head = newHead.next;
    }

    public class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
