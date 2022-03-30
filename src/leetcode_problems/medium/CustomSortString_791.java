package leetcode_problems.medium;

public class CustomSortString_791 {

    // Time complexity: O(n). Space complexity: O(n)
    public String customSortString(String order, String s) {
        int[] counts = new int[26];
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) counts[c - 'a']++;

        for (char c : order.toCharArray()) {
            while (counts[c - 'a']-- > 0) sb.append(c);
        }

        for (int i = 0; i < counts.length; i++) {
            for (int j = 0; j < counts[i]; j++) {
                sb.append((char) (i + 'a'));
            }
        }
        return sb.toString();
    }
}
