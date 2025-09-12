package leetcode_problems.medium;

public class VowelsGameInAString_3227 {

    public boolean doesAliceWin(String s) {
        return hasAnyVowel(s);
    }

    private boolean hasAnyVowel(String s) {
        for(int i = 0; i < s.length(); i ++) {
            if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i'
                    || s.charAt(i) == 'o' || s.charAt(i) == 'u') return true;
        }
        return false;
    }
}
