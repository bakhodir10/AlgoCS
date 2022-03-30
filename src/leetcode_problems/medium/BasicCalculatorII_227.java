package leetcode_problems.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class BasicCalculatorII_227 {

    // Time complexity: O(n). Space complexity: O(n)
    public int calculate1(String s) {

        int sum = 0, currNum = 0;
        char lastOperation = '+';
        Stack<Integer> nums = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);

            if (Character.isDigit(currChar)) currNum = (currNum * 10) + (currChar - '0');
            Arrays.binarySearch(new int[10], 10);
            if (!Character.isWhitespace(currChar) && !Character.isDigit(currChar) || i == s.length() - 1) {
                if (lastOperation == '+') nums.push(currNum);
                else if (lastOperation == '-') nums.push(-currNum);
                else if (lastOperation == '*') nums.push(nums.pop() * currNum);
                else if (lastOperation == '/') nums.push(nums.pop() / currNum);

                currNum = 0;
                lastOperation = currChar;
            }
        }
        while (!nums.isEmpty()) sum += nums.pop();
        return sum;
    }

    // Time complexity: O(n). Space complexity: O(n)
    public int calculate2(String s) {

        int idx = 0, sum = 0;
        LinkedList<Integer> numbers = new LinkedList<>();
        LinkedList<Character> signs = new LinkedList<>();
        char[] c = s.toCharArray();

        while (idx < c.length) {
            if (c[idx] == ' ') idx++;
            else if (isSign(c[idx])) signs.addLast(c[idx++]);
            else {
                int[] numWithIdx = getNum(c, idx);
                int currNum = numWithIdx[0];
                int lastIdx = numWithIdx[1];

                if (numbers.isEmpty()) numbers.addLast(currNum);
                else if (signs.getLast() == '*' || signs.getLast() == '/') {
                    int lastNum = numbers.removeLast();
                    char sign = signs.removeLast();

                    if (sign == '*') numbers.addLast(lastNum * currNum);
                    else if (sign == '/') numbers.addLast(lastNum / currNum);
                } else numbers.addLast(currNum);

                idx = lastIdx;
            }
        }

        while (!signs.isEmpty()) {

            int first = numbers.removeFirst();
            int second = numbers.removeFirst();
            char sign = signs.removeFirst();

            if (sign == '+') {
                sum = first + second;
                numbers.addFirst(sum);
            } else if (sign == '-') {
                sum = first - second;
                numbers.addFirst(sum);
            }
        }
        return !numbers.isEmpty() ? numbers.getFirst() : sum;
    }

    private int[] getNum(char[] c, int idx) {
        int num = 0;
        while (idx < c.length && c[idx] >= '0' && c[idx] <= '9') num = num * 10 + (c[idx++] - '0');
        return new int[]{num, idx};
    }

    private boolean isSign(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
}
