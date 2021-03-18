package problems.easy;

public class CheckBinaryString_1784 {

    // Time complexity: O(n). Space complexity: O(1)
    public boolean checkOnesSegment(String s) {
        boolean facedZero = false;
        boolean facedOneAfterZero = false;

        for (char c : s.toCharArray()) {
            if (c == '0') facedZero = true;
            if (facedZero && c == '1') facedOneAfterZero = true;
        }
        return !facedZero || !facedOneAfterZero;
    }
}
