package leetcode_problems.easy;

public class FindCenterStarGraph_1791 {

    // Time complexity: O(n). Space complexity: O(1)
    public int findCenter(int[][] edges) {
        int pC1 = edges[0][0];
        int pC2 = edges[0][1];

        for (int[] edge : edges) {
            if (edge[0] != pC1 && edge[1] != pC1) return pC2;
            if (edge[0] != pC2 && edge[1] != pC2) return pC1;
        }
        return -1;
    }
}