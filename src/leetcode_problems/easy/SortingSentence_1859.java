package leetcode_problems.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SortingSentence_1859 {

    // Time complexity: O(nlogn). Space complexity: O(n)
    public String sortSentence1(String s) {
        String[] arr = s.split(" ");
        Arrays.sort(arr, (e1, e2) -> e1.charAt(e1.length() - 1) - e2.charAt(e2.length() - 1));
        StringBuilder sb = new StringBuilder();

        for (String word : arr) sb.append(word, 0, word.length() - 1).append(" ");
        return sb.toString().trim();
    }

    // Time complexity: O(n). Space complexity: O(n)
    public String sortSentence2(String sentence) {
        String[] words = sentence.split(" ");
        Map<Integer, String> orders = new HashMap<>();

        for (String word: words) orders.put(Integer.parseInt(word.substring(word.length() - 1)), word.substring(0, word.length() - 1));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) sb.append(orders.get(i + 1)).append(" ");
        return sb.toString().trim();
    }
}