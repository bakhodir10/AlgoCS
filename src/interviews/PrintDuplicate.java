package interviews;

public class PrintDuplicate {

    // approach 1. Time complexity: O(n). Space complexity: O(n)
    public static String printDuplicate(String s) {

        int counts[] = new int[256];
        StringBuilder res = new StringBuilder();

        if (s == null) return res.toString();

        for (char c : s.toCharArray()) counts[c]++;

        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 1) res.append((char) i);
        }

        return res.toString();
    }
}
