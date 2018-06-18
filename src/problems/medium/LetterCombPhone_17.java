package problems.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LetterCombPhone_17 {

    public static List<String> letterCombinations(String digits) {
        int i = 1;
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) return res;

        String first = letters(digits.charAt(0));
        for (char c : first.toCharArray()) res.add(c + "");

        while (i < digits.length()) {
            String s = letters(digits.charAt(i));
            Set<String> temp = new HashSet<>(res);
            res = new ArrayList<>();
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                for (String r : temp) res.add(r + c + "");
            }
            i++;
        }
        return res;
    }

    private static String letters(char c) {
        switch (c) {
            case '2':
                return "abc";
            case '3':
                return "def";
            case '4':
                return "ghi";
            case '5':
                return "jkl";
            case '6':
                return "mno";
            case '7':
                return "pqrs";
            case '8':
                return "tuv";
            case '9':
                return "wxyz";
        }
        return "";
    }
}
