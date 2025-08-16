package neetcode.arrays_hashing;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecode {

    // m -> sum of lengths of all the strings
    // n -> number of string array
    // Time complexity: O(m) for each encode call
    // Space complexity: O(n + m) for each encode call
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s: strs) sb.append(s.length()).append('#').append(s);
        return sb.toString();
    }

    // Time complexity: O(m) for decode call
    // Space complexity: O(n + m) for each decode call
    public List<String> decode(String str) {
        int i = 0;
        List<String> res = new ArrayList<>();
        while(i < str.length()) {
            int j = i;
            int count = 0;
            while(str.charAt(j) != '#') {
                count = (count * 10) + str.charAt(j) - '0';
                j++;
            }
            j++;

            StringBuilder sb = new StringBuilder();
            for(int k = 0; k < count; k++) {
                sb.append(str.charAt(j));
                j++;
            }
            res.add(sb.toString());
            i = j;
        }
        return res;
    }
}
