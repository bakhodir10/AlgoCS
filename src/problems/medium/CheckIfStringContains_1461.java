package problems.medium;

import java.util.HashSet;
import java.util.Set;

public class CheckIfStringContains_1461 {

    // Time complexity: O(2^k). Space complexity: O(n)
    public boolean hasAllCodes1(String s, int k) {
        Set<String> set = new HashSet<>();

        for (int i = 0; i < s.length() && k + i <= s.length(); i++) set.add(s.substring(i, k + i));

        for (int i = 0; i < Math.pow(2, k); i++) {
            String binary = Integer.toBinaryString(i);
            binary = "0".repeat(k - binary.length()) + binary;
            if (!set.contains(binary)) return false;
        }
        return true;
    }

    // Time complexity: O(n). Space complexity: O(n)
    public boolean hasAllCodes2(String s, int k) {
        Set<String> substrings = new HashSet<>();

        for (int i = 0; i < s.length() && k + i <= s.length(); i++) {
            substrings.add(s.substring(i, k + i));
            if (substrings.size() == 1 << k /* Math.pow(2, k)*/) return true;
        }
        return false;
    }
}