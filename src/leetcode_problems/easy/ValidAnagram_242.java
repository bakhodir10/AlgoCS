package leetcode_problems.easy;

public class ValidAnagram_242 {

    public boolean isAnagram(String s, String t) {
        int[] dic = new int[26];
        for (char c : s.toCharArray()) dic[c - 'a']++;
        for (char c : t.toCharArray()) dic[c - 'a']--;
        for (int i : dic) {
            if (i != 0) return false;
        }
        return true;
    }
}
