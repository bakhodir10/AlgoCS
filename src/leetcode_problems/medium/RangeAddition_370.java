package leetcode_problems.medium;

public class RangeAddition_370 {

    // Time complexity: O(length * updates.length). Space complexity: O(length)
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];

        for (int[] update : updates) {
            int l = update[0];
            int r = update[1];
            int val = update[2];

            update(res, l, r, val);
        }
        return res;
    }

    private void update(int[] arr, int l, int r, int val) {
        while (l <= r) arr[l++] += val;
    }
}
