package problems.easy;

public class VerifyingAlienDictionary_953 {

    // Time complexity: O(n). Space complexity: O(1)
    public boolean isAlienSorted(String[] words, String order) {
        int[] arr = new int[26];

        for (int i = 0; i < order.length(); i++) arr[order.charAt(i) - 'a'] = i + 1;

        outer:
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            int j = 0;

            while (j < word1.length() && j < word2.length()) {
                if (arr[word1.charAt(j) - 'a'] < arr[word2.charAt(j) - 'a']) continue outer;
                else if (arr[word1.charAt(j) - 'a'] > arr[word2.charAt(j) - 'a']) return false;
                else j++;
            }
            if (word1.length() > word2.length()) return false;
        }
        return true;
    }
}
