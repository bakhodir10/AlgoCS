package skiena_book;

import java.util.HashMap;
import java.util.Map;

public class Ex3_29 {

    public String findWordPair(String s) {
        String[] wordArr = s.split(" ");
        Map<String, Integer> wordPairs = new HashMap<>();
        String greatestFreq = null;
        int maxFreqCount = Integer.MIN_VALUE;

        for (int i = 0; i < wordArr.length - 1; i++) {
            String first = wordArr[i];
            String second = wordArr[i + 1];
            int count = wordPairs.getOrDefault(first + " " + second, 0);
            wordPairs.put(first + " " + second, ++count);
        }

        for (Map.Entry<String, Integer> entry : wordPairs.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            if (value > maxFreqCount) {
                maxFreqCount = value;
                greatestFreq = key;
            }
        }
        return greatestFreq;
    }
}