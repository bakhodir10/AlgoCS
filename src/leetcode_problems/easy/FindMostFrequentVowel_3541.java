package leetcode_problems.easy;

public class FindMostFrequentVowel_3541 {

    public int maxFreqSum(String s) {
        int max1 = 0, max2 = 0;
        int[] counts = new int[26];

        for(int i = 0; i < s.length(); i ++) counts[s.charAt(i) - 'a']++;

        for(int i = 0; i < s.length(); i ++) {
            int count = counts[s.charAt(i) - 'a'];
            if(isVowel(s.charAt(i))) max1 = Math.max(max1, count);
            else max2 = Math.max(max2, count);
        }
        return max1 + max2;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
