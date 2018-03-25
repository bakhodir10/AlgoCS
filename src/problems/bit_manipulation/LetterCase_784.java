package problems.bit_manipulation;

import java.util.ArrayList;
import java.util.List;

public class LetterCase_784 {
    public List<String> letterCasePermutation(String S) {
        List<String> ans = new ArrayList<>();
        helper(ans, S.toCharArray(), 0);
        return ans;
    }

    private void helper(List<String> ans, char[] cs, int i) {
        if (i == cs.length) {
            ans.add(new String(cs));
        } else if ('0' <= cs[i] && cs[i] <= '9') {
            helper(ans, cs, i + 1);
        } else {
            cs[i] = Character.toLowerCase(cs[i]);
            helper(ans, cs, i + 1);
            cs[i] = Character.toUpperCase(cs[i]);
            helper(ans, cs, i + 1);
        }
    }
}