package problems.easy.stack;

import java.util.Stack;

public class StackInsertionSort {
    public static Stack<Integer> insertionSort(Stack<Integer> st) {
        Stack<Integer> tempSt = new Stack<>();
        while (st.size() != 0) {
            int x = st.pop();
            while (!tempSt.empty() && x < tempSt.peek()) st.push(tempSt.pop());
            tempSt.push(x);
        }
        return tempSt;
    }
}
