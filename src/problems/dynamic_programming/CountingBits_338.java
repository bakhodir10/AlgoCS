package problems.dynamic_programming;

public class CountingBits_338 {

    // approach 1
    public int[] countBits1(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i < res.length; i++)
            res[i] = res[i / 2] + i % 2;
        return res;
    }

    // approach 2
    public int[] countBits2(int num) {
        int n[] = new int[num + 1];
        for (int i = 0; i < n.length; i++) {
            n[i] = Integer.bitCount(i);
        }
        return n;
    }
}
