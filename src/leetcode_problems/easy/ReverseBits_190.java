package leetcode_problems.easy;

public class ReverseBits_190 {

    public int reverseBits(int n) {
        String binary = Integer.toBinaryString(n);
        StringBuilder sb = new StringBuilder();

        sb.append("0".repeat(32 - binary.length()));
        sb.append(binary);
        sb.reverse();
        long res = Long.parseLong(sb.toString(), 2);
        return (int)res;
    }
}
