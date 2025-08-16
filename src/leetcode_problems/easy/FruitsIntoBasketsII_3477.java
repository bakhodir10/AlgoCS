package leetcode_problems.easy;

public class FruitsIntoBasketsII_3477 {

    // This problem could be solved with Segment tree which is nlogn time complexity.
    // However, since the input size is small(n <= 100), brute force also works.
    // Time complexity: O(n^2)
    // Space complexity: O(1)
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int placed = 0;

        for (int fruit : fruits) {
            for (int j = 0; j < baskets.length; j++) {
                if (fruit <= baskets[j]) {
                    placed++;
                    baskets[j] = 0;
                    break;
                }
            }
        }
        return fruits.length - placed;
    }
}
