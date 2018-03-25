package problems.array;

import java.util.Stack;

public class PlusOne_66 {
    public static int[] plusOne(int[] digits) {
        int i = digits.length - 1, k = 0, remainder = 1;
        Stack<Integer> st = new Stack<>();
        while (i >= 0) {
            int sum = digits[i] + remainder;
            if (sum == 10) {
                st.push(0);
                remainder = 1;
            } else {
                st.push(sum);
                remainder = 0;
            }
            i--;
        }
        if (remainder == 1) st.push(1);
        int arr[] = new int[st.size()];
        while (!st.isEmpty()) arr[k++] = st.pop();
        return arr;
    }
}
