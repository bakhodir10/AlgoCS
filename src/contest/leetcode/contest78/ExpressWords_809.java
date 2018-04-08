package contest.leetcode.contest78;

import java.util.HashMap;
import java.util.Map;

// todo not finished
public class ExpressWords_809 {
    public static void main(String[] args) {
        System.out.println(expressiveWords("heeellooo", new String[]{"hello", "hi", "helo"}));
    }

    public static int expressiveWords(String s, String words[]) {
        int ans = 0;

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            boolean ex = map.containsKey(s.charAt(i));
            if (!ex) {
                map.put(s.charAt(i), 1);
            } else {
                int t = map.get(s.charAt(i));
//                map.put(s.charAt(i))
            }
        }
        return ans;
    }
}
