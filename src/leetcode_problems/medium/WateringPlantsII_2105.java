package leetcode_problems.medium;

public class WateringPlantsII_2105 {

    // Time complexity: O(n). Space complexity: O(1)
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int l = 0, r = plants.length - 1;
        int capA = capacityA;
        int capB = capacityB;
        int count = 0;

        while (l <= r) {
            if (l == r) {
                if (capA >= capB) {
                    if (capA < plants[l++]) count++;
                } else {
                    if (capB < plants[r--]) count++;
                }
            } else {
                if (capA < plants[l]) {
                    capA = capacityA;
                    count++;
                }
                capA -= plants[l++];

                if (capB < plants[r]) {
                    capB = capacityB;
                    count++;
                }
                capB -= plants[r--];
            }
        }
        return count;
    }
}
