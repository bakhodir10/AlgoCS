package leetcode_problems.medium;

public class MaxNumOfVowelsSubstrOfGivenLen_1456 {

    // Time complexity: O(n). Each character is checked once
    // Space complexity: O(1)
    public int maxVowels1(String s, int k) {
        int currCount = 0, max = 0, l = 0, r = 0;

        for(int i = 0; i < k; i ++) {
            if(isVowel(s.charAt(i))) currCount++;
        }

        max = currCount;
        for(int i = k; i < s.length(); i ++) {
            if(isVowel(s.charAt(i - k))) currCount--;
            if(isVowel(s.charAt(i))) currCount++;
            max = Math.max(max, currCount);
        }
        return max;
    }

    // Time complexity: O(n). Each character is checked twice at most
    // Space complexity: O(1)
    public int maxVowels2(String s, int k) {
        int currCount = 0, max = 0, l = 0, r = 0;

        while(r < s.length()) {
            if(r - l < k) {
                if(isVowel(s.charAt(r))) currCount++;
                max = Math.max(max, currCount);
                r++;
            } else {
                if(isVowel(s.charAt(l))) currCount--;
                l++;
            }
        }
        return max;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
