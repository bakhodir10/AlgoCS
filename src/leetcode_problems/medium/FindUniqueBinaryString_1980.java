package leetcode_problems.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindUniqueBinaryString_1980 {

    // Time complexity: O(n^2)
    /*
      As per constraints, we know that the size of nums is n. When we recursively generate strings,
        in the worst case we generate n+1 strings and not 2^n strings. That's because the first n strings
        that we generate could already be present in the nums set, but the (n+1)th binary string
        that we generate is guaranteed to be unique.
      Each time we generate a string, we check if it already exists in the set. We make n recursive calls
        to generate a string of length n, and we generate n strings. After a string is generated we perform
        a lookup in the set, which happens in O(1) time.

      Time Complexity
        O(n) (Number of generated strings) x O(n) (Number of recursive calls made to generate a string)
        x O(1) (Lookup of the generated string in the set) = O(n^2)
     */
    // Space complexity: O(n^2). uniques keeps n length of string that has n number of characters.
    private String foundPerm = "";
    public String findDifferentBinaryString(String[] nums) {
        if(nums.length == 0) return "";

        Set<String> uniques = new HashSet<>(Arrays.asList(nums));

        backtrack(nums[0].length(), "", uniques);
        return foundPerm;
    }

    private void backtrack(int n, String sub, Set<String> uniques) {
        if(!foundPerm.isEmpty()) return;

        if(sub.length() == n) {
            if(!uniques.contains(sub)) foundPerm = sub;
            return;
        }

        backtrack(n, sub + "0", uniques);
        backtrack(n, sub + "1", uniques);
    }


    // Cantor's diagonal argument: https://en.wikipedia.org/wiki/Cantor%27s_diagonal_argument
    // Time complexity: O(n)
    // Space complexity: O(1)
    public String findDifferentBinaryString2(String[] nums) {
        StringBuilder ans = new StringBuilder();

        for(int i = 0; i < nums.length; i ++) {
            char c = nums[i].charAt(i);
            ans.append(c == '0' ? '1' : '0');
        }
        return ans.toString();
    }
}
