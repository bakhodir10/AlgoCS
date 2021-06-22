package leetcode_problems.medium;

public class NumberSubstringsThreeChars_1358 {

    public int numberOfSubstrings(String s) {
        int[] arr = {0, 0, 0};
        int count = 0, res = 0, slow = 0;

        for (int fast = 0; fast < s.length(); fast++) {
            arr[s.charAt(fast) - 'a']++;

            while (arr[0] > 0 && arr[1] > 0 && arr[2] > 0) {
                arr[s.charAt(slow++) - 'a']--;
                count++;
            }
            res += count;
        }
        return res;
    }
}
