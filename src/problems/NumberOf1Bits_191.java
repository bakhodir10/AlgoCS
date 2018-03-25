package problems;

public class NumberOf1Bits_191 {
    // approach 1
    public int hammingWeight1(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }

    // approach 2
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
}
