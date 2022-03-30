package leetcode_problems.medium;

import java.util.Stack;

public class SimplifyPath_71 {

    // Time complexity: O(n). Space complexity: O(n)
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        String[] pathArr = path.split("/");

        for (String s : pathArr) {
            s = s.replace("/", "");

            if (s.isEmpty()) continue;

            if (s.equals("..")) {
                if (!st.isEmpty()) st.pop();
            } else if (s.equals(".")) continue;
            else st.push(s);
        }

        StringBuilder res = new StringBuilder();

        for (String s : st) res.append("/").append(s);

        if (st.isEmpty()) res.append("/");

        return res.toString();
    }
}
