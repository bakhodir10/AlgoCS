package leetcode_problems.easy;

import java.util.Arrays;

public class MaximumUnitsTruck_1710 {

    // Time complexity: O(nlogn). Space complexity: O(1)
    public int maximumUnits1(int[][] boxTypes, int truckSize) {
        int max = 0;

        Arrays.sort(boxTypes, (e1, e2) -> e2[1] - e1[1]);

        for (int[] boxType : boxTypes) {
            int numberOfBoxes = boxType[0];
            int numberOfUnitsPerBox = boxType[1];

            if (truckSize > numberOfBoxes) {
                max += numberOfBoxes * numberOfUnitsPerBox;
                truckSize -= numberOfBoxes;
            } else {
                max += truckSize * numberOfUnitsPerBox;
                return max;
            }
        }
        return max;
    }

    // Time complexity: O(n). Space complexity: O(1)
    public int maximumUnits2(int[][] boxTypes, int truckSize) {
        int max = 0;
        int[] boxes = new int[1001];

        for (int[] boxType : boxTypes) boxes[boxType[1]] += boxType[0];

        for (int i = boxes.length - 1; i > 0 && truckSize > 0; i--) {
            int numberOfBoxes = boxes[i];

            if (numberOfBoxes == 0) continue;

            if (truckSize > numberOfBoxes) max += numberOfBoxes * i;
            else max += truckSize * i;

            truckSize -= numberOfBoxes;
        }
        return max;
    }
}
