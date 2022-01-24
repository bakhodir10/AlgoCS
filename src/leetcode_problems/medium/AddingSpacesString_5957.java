package leetcode_problems.medium;

public class AddingSpacesString_5957 {

    // Time complexity: O(n). Space complexity: O(1)
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;

        while (i < s.length() && j < spaces.length) {
            if (i == spaces[j]) {
                sb.append(" ");
                j++;
            } else {
                sb.append(s.charAt(i++));
            }
        }
        while (i < s.length()) sb.append(s.charAt(i++));
        return sb.toString();
    }
}
