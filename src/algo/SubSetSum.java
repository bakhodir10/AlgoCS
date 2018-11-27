package algo;

import java.util.ArrayList;
import java.util.List;

/*
    Generate all the subsets of given array
 */

// todo not finished
public class SubSetSum {
    public static void main(String[] args) {
        System.out.println(generateSubset(new int[]{1, 2, 3}));
    }

    /*
        Algorithm 1: Complete search, using bit operation
        Time complexity: O(2^n)
     */
    public static List<List<Integer>> generateSubset(int arr[]) {

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < Math.pow(2, arr.length); i++) {
            String bits = Integer.toBinaryString(i);
            List<Integer> sub = new ArrayList<>();
            for (int j = 0; j < bits.length(); j++) {
                if (bits.charAt(j) == '1') sub.add(arr[j]);
            }
            System.out.println(bits);
            ans.add(sub);
        }

        for (List<Integer> an : ans) {
            System.out.println(an);
        }
        return ans;
    }
}
