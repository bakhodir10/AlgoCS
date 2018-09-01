package interviews;

public class FirstNonRepeatedChar {

    // approach 1. Time complexity: O(n). Space complexity: O(1)
    public static char firstNonRepeatedChar(String s) {
        if (s == null) return ' ';
        int count[] = new int[255];
        char characters[] = s.toCharArray();

        for (char c : characters) count[c]++;

        for (char c : characters) {
            if (count[c] == 1) return c;
        }
        return ' ';
    }
}
