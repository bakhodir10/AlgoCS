package crack_code_interview.chapter1;

/*
    Check Permutation: Given two strings, write a method to decide if one is a permutation of the
    other.
 */

import java.util.Arrays;

public class CheckPermutation {

    // approach 1. Time complexity O(nlogn). Space complexity O(n)
    public boolean checkPermutation1(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        char c1[] = s1.toCharArray();
        char c2[] = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        for (int i = 0; i < c1.length; i++) {
            if (c1[i] != c2[i]) return false;
        }
        return true;
    }

    // approach 2. Time complexity O(n). Space complexity O(1)
    public boolean checkPermutation2(String s1, String s2) {
        int count[] = new int[256];

        for (char c : s1.toCharArray()) count[c]++;
        for (char c : s2.toCharArray()) count[c]--;

        for (int c : count) {
            if (c != 0) return false;
        }
        return true;
    }
}
