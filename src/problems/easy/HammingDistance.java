package problems.easy;

public class HammingDistance {
    public static int hammingDistance(int x, int y){
        return Integer.bitCount(x ^ y);
    }
}
