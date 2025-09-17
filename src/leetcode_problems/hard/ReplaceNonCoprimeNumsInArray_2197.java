package leetcode_problems.hard;

import java.util.*;

public class ReplaceNonCoprimeNumsInArray_2197 {

    public List<Integer> replaceNonCoprimes(int[] nums) {
        Deque<Integer> st = new ArrayDeque<>();

        for(int num: nums) {
            st.push(num);

            while(st.size() > 1) {
                int e1 = st.pop();
                int e2 = st.pop();
                int gcd = gcd(e1, e2);

                if(gcd > 1) {
                    int lcm = lcm(e1, e2, gcd);
                    st.push((int)lcm);
                } else {
                    st.push(e2);
                    st.push(e1);
                    break;
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        while(!st.isEmpty()) result.add(st.pop());
        Collections.reverse(result);

        return result;
    }

    private int lcm(int a, int b, int gcd) {
        if (a == 0 || b == 0) return 0;
        return (a / gcd) * b;
    }

    private int gcd(int x, int y) {
        if(x  < y) {
            int temp = x;
            x = y;
            y = temp;
        }

        while(y != 0) {
            int temp = x;
            x = y;
            y = temp % y;
        }
        return x;
    }
}
