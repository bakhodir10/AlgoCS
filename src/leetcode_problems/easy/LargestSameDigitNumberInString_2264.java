package leetcode_problems.easy;

public class LargestSameDigitNumberInString_2264 {

    public String largestGoodInteger(String num) {
        int max = -1;
        for(int i = 0; i < num.length() - 2; i++) {
            if(num.charAt(i) == num.charAt(i + 1) && num.charAt(i + 1) == num.charAt(i + 2)) {
                max = Math.max(max, Integer.parseInt(num.substring(i, i + 3)));
            }
        }
        return max == -1 ? "" : max == 0 ? "000" : String.valueOf(max);
    }
}
