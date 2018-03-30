package problems.hard;

import java.util.Stack;

// todo not done
public class MaxChunks_768 {
    public int maxChunksToSorted(int[] arr) {
        int count = 1;
        Stack<Integer> st = new Stack<>();
        st.push(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > st.peek()) {
                st.push(arr[i]);
                count++;
            }
        }
        return count == 0 ? 1 : count;
    }
}
