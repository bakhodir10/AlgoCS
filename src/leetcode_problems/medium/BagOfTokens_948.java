package leetcode_problems.medium;

import java.util.Arrays;

public class BagOfTokens_948 {

    // Time complexity: O(nlogn)
    // Space complexity: O(logn) for recursive call
    public int bagOfTokensScore(int[] tokens, int power) {
        int l = 0, r = tokens.length - 1, score = 0;

        Arrays.sort(tokens);
        while(l <= r) {
            if(tokens[l] <= power) {
                power -= tokens[l];
                l++;
                score++;
            } else if(l < r && score > 0){
                power += tokens[r];
                r--;
                score--;
            } else {
                l++;
            }
        }
        return score;
    }
}
