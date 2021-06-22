package leetcode_problems.easy;

public class Sqrt_69 {
    private static int binarySearch(int low, int high, int x) {
        int middle = (low + high) / 2;
        if (low > high) return high;
        if (middle == x / middle) return middle;
        else if (middle > x / middle) return binarySearch(low, middle - 1, x);
        else return binarySearch(middle + 1, high, x);
    }
}
