package leetcode_problems.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class CreateTargetArray_1389 {

    // Time complexity: O(nums.length ^ 2). Space complexity: O(n)
    public int[] createTargetArray1(int[] nums, int[] index) {
        Stack<Integer> st = new Stack<>();
        int[] res = new int[nums.length];
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            Stack<Integer> temp = new Stack<>();

            while (st.size() != index[i] && !st.isEmpty()) temp.add(st.pop());
            st.push(nums[i]);
            while (!temp.isEmpty()) st.push(temp.pop());
        }

        Collections.reverse(st);
        while (!st.isEmpty()) res[k++] = st.pop();

        return res;
    }

    // Time complexity: O(nums.length ^ 2). Space complexity: O(n)
    public int[] createTargetArray2(int[] nums, int[] index) {
        List<Integer> list = new ArrayList<>();
        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            list.add(index[i], nums[i]);
        }

        for (int i = 0; i < list.size(); i++) res[i] = list.get(i);

        return res;
    }
}
