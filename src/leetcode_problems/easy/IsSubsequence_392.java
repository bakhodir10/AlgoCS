package leetcode_problems.easy;

public class IsSubsequence_392 {

    // Time complexity: O(n)
    // Space complexity: O(1)
    public boolean isSubsequence(String s, String t) {
        int sp = 0, tp = 0;
        while(sp < s.length() && tp < t.length()) {
            if(s.charAt(sp) == t.charAt(tp)) sp++;
            tp++;
        }
        return sp == s.length();
    }
}
