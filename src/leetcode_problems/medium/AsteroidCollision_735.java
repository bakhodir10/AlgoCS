package leetcode_problems.medium;

import java.util.Stack;

public class AsteroidCollision_735 {

    // Time complexity: O(n). Space complexity: O(n)
    // Idea: there will be 4 possible asteroids => ++, --, +-, -+.
    // The only time it crashes when it is +-
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> st = new Stack<>();

        for (int asteroid : asteroids) {
            if (asteroid > 0) st.push(asteroid); // when it is + there is no crash no matter prev one is
            else {
                // when it is +- and then there will be crash, and we need to destroy if the prev is smaller than curr one
                while (!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(asteroid)) {
                    st.pop();
                }
                // after removing if it is still -- and then just save it since there is no crash
                if (st.isEmpty() || st.peek() < 0) {
                    st.push(asteroid);
                } else if (st.peek() == Math.abs(asteroid)) { // if they are equal weight of asteroids and then both will get destroyed
                    st.pop();
                }
            }
        }

        int idx = 0;
        int[] res = new int[st.size()];

        for (int size : st) res[idx++] = size;
        return res;
    }
}
