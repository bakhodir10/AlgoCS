package crack_code_interview.chapter1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
      Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you
      cannot use additional data structures?
 */
public class IsUnique {

    // approach 1. Time complexity: O(nlogn). Space complexity: O(n)
    public boolean isUnique1(String s) {
        char arr[] = s.toCharArray();
        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) return false;
        }
        return true;
    }

    // approach 2. Time complexity: O(n). Space complexity: O(1)
    public boolean isUnique2(String s) {
        Set<Character> counts = new HashSet<>(256);
        for (char c : s.toCharArray()) {
            if (counts.contains(c)) return false;
            counts.add(c);
        }
        return true;
    }

    // approach 3. Time complexity: O(n). Space complexity: O(1)
    public boolean isUnique3(String s) {
        boolean counts[] = new boolean[256];
        for (char c : s.toCharArray()) {
            if (counts[(int) c]) return false;
            counts[(int) c] = true;
        }
        return true;
    }
}
