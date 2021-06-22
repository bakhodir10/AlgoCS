package leetcode_problems.easy;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring_3 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int i = 0, max = 0;

        while(i < s.length()){
            char c = s.charAt(i);
            boolean b = set.contains(c);
            if(b) {
                max = Math.max(set.size(), max);
                set.clear();
            }
            set.add(c);
            i++;
        }
        return max;
    }
}
