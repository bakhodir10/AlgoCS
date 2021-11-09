package leetcode_problems.easy;

public class ShortestWordDistance_243 {

    // Time complexity: O(n). Space complexity: O(1)
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int first = -1, second = -1, min = Integer.MAX_VALUE;

        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1)) first = i;
            else if (wordsDict[i].equals(word2)) second = i;

            if (first != -1 && second != -1) min = Math.min(min, Math.abs(first - second));
        }
        return min;
    }
}
