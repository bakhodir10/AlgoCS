package problems.easy;

public class ShuffleString_1528 {

    // Time complexity: O(n). Space complexity: O(n)
    public String restoreString(String s, int[] indices) {
        char[] c = new char[indices.length];
        for (int i = 0; i < indices.length; i++) c[indices[i]] = s.charAt(i);
        return String.valueOf(c);
    }
}
