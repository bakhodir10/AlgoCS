package leetcode_problems.medium;

public class LongestSubstWithoutRepChars_3 {

    public int lengthOfLongestSubstring(String s) {
        int[] arr = new int[256];
        int max = 0, slow = 0;

        for (int fast = 0; fast < s.length(); fast++) {
            arr[s.charAt(fast)]++;

            while (arr[s.charAt(fast)] != 1) arr[s.charAt(slow++)]--;

            if (max == 0) max = fast - slow + 1;
            else max = Math.max(max, fast - slow + 1);
        }
        return max;
    }
}