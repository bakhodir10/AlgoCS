package leetcode_problems.easy;

public class LongestCommonPrefix_14 {
    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) return "";
        StringBuilder prefix = new StringBuilder();

        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if (i >= strs[j].length()) return prefix.toString();
                char cc = strs[j].charAt(i);
                if (c != cc) return prefix.toString();
            }
            prefix.append(c);
        }
        return prefix.toString();
    }
}
