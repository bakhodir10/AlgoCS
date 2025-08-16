package leetcode_problems.medium;

public class ReverseWordsInAString_151 {

    // Time complexity: O(n)
    // Space complexity: O(n)
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] words = s.split(" ");

        for(int i = words.length - 1; i >= 0; i--) {
            if(!words[i].trim().isEmpty()) sb.append(words[i]).append(" ");
        }
        return sb.toString().trim();
    }
}
