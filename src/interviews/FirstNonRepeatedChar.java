package interviews;

public class FirstNonRepeatedChar {

    // approach 1. Time complexity: O(n). Space complexity: O(1)
    public static char firstNonRepeatedChar(String s) {
        if (s == null) return ' ';
        int count[] = new int[255];

        for (char c : s.toCharArray()) count[c]++;

        for (char c : s.toCharArray()) {
            if (count[c] == 1) return c;
        }
        return ' ';
    }
}
