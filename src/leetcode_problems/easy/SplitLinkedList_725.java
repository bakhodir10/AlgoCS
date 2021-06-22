package leetcode_problems.easy;

// todo not done
public class SplitLinkedList_725 {
    public ListNode[] splitListToParts(ListNode root, int k) {
        if (root == null) return null;
        ListNode[] list = new ListNode[k];
        ListNode temp = root;
        int size = 0, count = 0, sum = list.length, i = 0;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        temp = root;
        while (temp != null) {
            ListNode n = new ListNode(temp.val);
            int j = 0;
            while (j < k / size && temp.next != null) {
                n.next = temp.next;
                temp = temp.next;
                j++;
            }
            temp = temp.next;
            list[i++] = n;
        }
        return list;
    }

    private class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
