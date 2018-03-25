package problems.bit_manipulation;

public class HammingDist_461 {
    public static int hammingDistance(int x, int y){
        return Integer.bitCount(x ^ y);
    }
}
