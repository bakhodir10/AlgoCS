package leetcode_problems.easy;

public class FinalValueVariable_2011 {

    // Time complexity: O(n). Space complexity: O(1)
    public int finalValueAfterOperations(String[] operations) {
        int val = 0;

        for (String operation : operations) {
            if (operation.charAt(0) == '-' || operation.charAt(1) == '-') val--;
            else val++;
        }
        return val;
    }
}
