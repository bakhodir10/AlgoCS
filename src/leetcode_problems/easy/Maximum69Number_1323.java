package leetcode_problems.easy;

public class Maximum69Number_1323 {

    // Time complexity: O(n). Space complexity: O(n)
    public int maximum69Number1(int num) {
        char[] numArr = String.valueOf(num).toCharArray();
        StringBuilder newNum = new StringBuilder();
        int flipCount = 0;

        for (char c : numArr) {
            if (flipCount < 1 && c == '6') {
                newNum.append('9');
                flipCount++;
            } else newNum.append(c);
        }
        return Integer.parseInt(newNum.toString());
    }

    // Time complexity: O(n). Space complexity: O(1)
    public int maximum69Number2(int num) {
        return Integer.parseInt((String.valueOf(num)).replaceFirst("6", "9"));
    }
}
