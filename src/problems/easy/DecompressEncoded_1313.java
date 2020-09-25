package problems.easy;

import java.util.Arrays;

public class DecompressEncoded_1313 {

    public int[] decompressRLElist(int[] nums) {
        int counter = 0;
        for (int i = 0; i < nums.length; i += 2) counter += nums[i];
                      
        int[] output = new int[counter];
        int k = 0;
        for (int i = 0; i < nums.length; i += 2) {
            Arrays.fill(output, k, k + nums[i], nums[i + 1]);
            k += nums[i];
        }
        return output;
    }
}