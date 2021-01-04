package problems.easy;

public class CountNumberConsist_1684 {

    // Time complexity: O(n). Space complexity: O(n);
    public int countConsistentStrings(String allowed, String[] words) {
        int count = 0;

        boolean[] b = new boolean[26];
        for (char c : allowed.toCharArray()) b[c - 'a'] = true;

        outer:
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (!b[c - 'a']) continue outer;
            }
            count++;
        }
        return count;
    }
}