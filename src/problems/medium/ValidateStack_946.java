package problems.medium;

import java.util.Stack;

public class ValidateStack_946 {

    // Time complexity: O(pushed.length + popped.length). Space complexity: O(n)
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int i = 0, j = 0;
        Stack<Integer> st = new Stack<>();

        while (i < pushed.length) {
            st.push(pushed[i++]);
            while (!st.isEmpty() && st.peek() == popped[j] && j < popped.length) {
                st.pop();
                j++;
            }
        }
        return st.isEmpty();
    }
}