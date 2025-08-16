package leetcode_problems.medium;

public class NumberOfStudentReplacements_3616 {

    // Time complexity: O(n)
    // Space complexity: O(1)
    public int totalReplacements(int[] ranks) {
        int count = 0;
        int min = ranks[0];

        for (int rank : ranks) {
            if (min > rank) {
                min = rank;
                count++;
            }
        }
        return count;
    }
}
