package problems.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NextGreaterNode_1019 {

    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int[] res = new int[list.size()];
        Stack<Integer> st = new Stack<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            int num = list.get(i);
            while (!st.isEmpty() && st.peek() <= num) st.pop();
            if (st.isEmpty()) res[i] = 0;
            else res[i] = st.peek();
            st.push(num);
        }
        return res;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
