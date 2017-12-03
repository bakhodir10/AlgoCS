package problems.easy.math;

public class HammingDistance_461 {
    public static int hammingDistance(int x, int y){
        return Integer.bitCount(x ^ y);
    }
}
