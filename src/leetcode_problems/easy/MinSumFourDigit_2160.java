package leetcode_problems.easy;

import java.util.PriorityQueue;

public class MinSumFourDigit_2160 {

    // Time complexity: O(nlogk). Space complexity: O(k);
    public int minimumSum1(int num) {
        PriorityQueue<Integer> pQ = new PriorityQueue<>();

        while (num != 0) {
            pQ.offer(num % 10);
            num /= 10;
        }

        int num1 = 0, num2 = 0;

        while (!pQ.isEmpty()) {
            num1 = num1 * 10 + pQ.poll();
            if (!pQ.isEmpty()) num2 = num2 * 10 + pQ.poll();
        }
        return num1 + num2;
    }

    // Time complexity: O(n). Space complexity: O(1);
    public int minimumSum2(int num) {
        int[] counts = new int[10000];
        int num1 = 0, num2 = 0;
        boolean firstTurn = true;

        while (num != 0) {
            counts[num % 10]++;
            num /= 10;
        }

        for (int i = 0; i < counts.length; i++) {
            for (int j = 0; j < counts[i]; j++) {
                if (firstTurn) {
                    num1 = num1 * 10 + i;
                    firstTurn = false;
                } else {
                    num2 = num2 * 10 + i;
                    firstTurn = true;
                }
            }
        }
        return num1 + num2;
    }
}
