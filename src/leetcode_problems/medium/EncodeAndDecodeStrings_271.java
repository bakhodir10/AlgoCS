package leetcode_problems.medium;

import java.util.LinkedList;
import java.util.List;

public class EncodeAndDecodeStrings_271 {

    // Time complexity: O(n*m). n -> size of the strs and m is the length of a string in strs
    // Space complexity: O(n*m).  m -> a string length

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        // Hello world Java
        // 5#Hello5#world4#Java

        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append("#").append(s);
        }
        return sb.toString();
    }

    // Time complexity: O(n*m). n -> length of the string
    // Space complexity: O(n*m).  m -> a string length

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        int p1 = 0;
        char[] c = s.toCharArray();
        List<String> result = new LinkedList<>();

        while (p1 < c.length) {
            int letterCount = 0;
            StringBuilder word = new StringBuilder();

            while (c[p1] != '#') {
                letterCount = letterCount * 10 + (c[p1] - '0');
                p1++;
            }

            p1++; // move by 1 because of #

            int readTill = p1 + letterCount;
            while (p1 < readTill) {
                word.append(c[p1]);
                p1++;
            }
            result.add(word.toString());
        }
        return result;
    }
}
