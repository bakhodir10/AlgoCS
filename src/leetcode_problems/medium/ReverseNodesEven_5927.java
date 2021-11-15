package leetcode_problems.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseNodesEven_5927 {

    // Time complexity: O(n). Memory complexity: O(n)
    public ListNode reverseEvenLengthGroups(ListNode head) {
        List<List<Integer>> list = new ArrayList<>();
        int idx = 0, group = 1;
        ListNode temp = head;

        while (temp != null) {
            int t = idx;
            List<Integer> subList = new ArrayList<>();
            while (temp != null && idx < t + group) {
                subList.add(temp.val);
                temp = temp.next;
                idx++;
            }
            if (subList.size() % 2 == 0) Collections.reverse(subList);
            list.add(subList);
            group++;
        }

        temp = head;

        for (List<Integer> subList : list) {
            for (int val : subList) {
                temp.val = val;
                temp = temp.next;
            }
        }
        return head;
    }

    private static class ListNode {
        int val;
        ListNode next;
    }
}
