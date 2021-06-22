package problems.medium;

public class CompareStringFrequency_1170 {

    // Time complexity: O(n*m). Space complexity: O(n+m)
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] counts = new int[queries.length];
        int[] countWords = new int[words.length];
        int[] countQueries = new int[queries.length];

        for (int i = 0; i < queries.length; i++) countQueries[i] = getF(queries[i]);
        for (int i = 0; i < words.length; i++) countWords[i] = getF(words[i]);

        for (int i = 0; i < queries.length; i++) {
            int count = 0;
            for (int j = 0; j < words.length; j++) {
                if (countQueries[i] < countWords[j]) count++;
            }
            counts[i] = count;
        }
        return counts;
    }

    private int getF(String s) {
        int[] count = new int[26];

        for (char c : s.toCharArray()) count[c - 'a']++;

        for (int i : count) {
            if (i != 0) return i;
        }
        return -1;
    }
}
