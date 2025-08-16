package leetcode_problems.easy;

public class MergeStringsAlternately_1768 {

    // Time complexity: O(n)
    // Space complexity: O(1)
    public String mergeAlternately(String word1, String word2) {
        int p1 = 0, p2 = 0, idx = 0;
        StringBuilder sb = new StringBuilder();

        while(p1 < word1.length() && p2 < word2.length()) {
            if(idx % 2 == 0) sb.append(word1.charAt(p1++));
            else sb.append(word2.charAt(p2++));
            idx++;
        }

        while(p1 < word1.length()) sb.append(word1.charAt(p1++));
        while(p2 < word2.length()) sb.append(word2.charAt(p2++));

        return sb.toString();
    }
}
