package leetcode_problems.hard;


import java.util.*;
import java.util.stream.Collectors;

public class MergeKSortedLists_23 {

    // Approach 1. Sorting. Time complexity: O(nlogn). Memory complexity: O(n)
    public ListNode mergeKLists1(ListNode[] lists) {
        List<Integer> list = new ArrayList<>();

        for (ListNode node : lists) {
            while (node != null) {
                list.add(node.val);
                node = node.next;
            }
        }
        Collections.sort(list);

        ListNode head = new ListNode(-1);
        ListNode temp = head;

        for (int val : list) {
            temp.next = new ListNode(val);
            temp = temp.next;
        }
        return head.next;
    }

    // Approach 2. Using PriorityQueue. Time complexity: O(nlogk). Memory complexity: O(k)
    public ListNode mergeKLists2(ListNode[] lists) {
        PriorityQueue<ListNode> pQ = new PriorityQueue<>((e1, e2) -> e1.val - e2.val);

        pQ.addAll(Arrays.stream(lists).filter(Objects::nonNull).collect(Collectors.toList()));

        ListNode head = new ListNode(-1);
        ListNode curr = head;

        while (!pQ.isEmpty()) {
            ListNode nodeInPq = pQ.poll();

            curr.next = nodeInPq;
            curr = curr.next;

            ListNode nextNodeInPq = nodeInPq.next;
            if (nextNodeInPq != null) pQ.add(nextNodeInPq);
        }
        return head.next;
    }

    // Approach 3. Merge lists one by one. Time complexity: O(nk). Memory complexity: O(1)
    public ListNode mergeKLists3(ListNode[] lists) {
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];

        ListNode head = mergeTwoLists(lists[0], lists[1]);

        for (int i = 2; i < lists.length; i++) {
            head = mergeTwoLists(head, lists[i]);
        }
        return head;
    }

    private ListNode mergeTwoLists(ListNode n1, ListNode n2) {
        ListNode res = new ListNode(-1);
        ListNode head = res;

        while (n1 != null && n2 != null) {
            if (n1.val > n2.val) {
                res.next = n2;
                n2 = n2.next;
            } else {
                res.next = n1;
                n1 = n1.next;
            }
            res = res.next;
        }
        if (n1 != null) res.next = n1;
        if (n2 != null) res.next = n2;

        return head.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}
