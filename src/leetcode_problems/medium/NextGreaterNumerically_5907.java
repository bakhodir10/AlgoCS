package leetcode_problems.medium;

public class NextGreaterNumerically_5907 {

    public int nextBeautifulNumber(int n) {
        int i = n + 1;
        while (i < Integer.MAX_VALUE) {
            if (find(i)) return i;
            i++;
        }
        return -1;
    }

    private boolean find(int n) {
        int[] arr = new int[10];

        while (n != 0) {
            arr[n % 10]++;
            n /= 10;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) continue;
            if (arr[i] != i) return false;
        }
        return true;
    }
}
