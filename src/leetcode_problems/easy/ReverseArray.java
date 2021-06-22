package leetcode_problems.easy;

import java.util.Stack;

public class ReverseArray<E> {
    public E[] reverse(E[] elem) {
        Stack<E> st = new Stack<>();
        for (int i = 0; i < elem.length; i++) st.push(elem[i]);
        for (int i = 0; i < st.size(); i++) elem[i] = st.pop();
        return elem;
    }
}
