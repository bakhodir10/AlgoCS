package problems.easy;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("Duplicates")
public class FindAllAnagrams_438 {

    public static List<Integer> findAnagrams(String word, String sub) {

        List<Integer> ans = new ArrayList<>();

        if (word.isEmpty()) return ans;

        int hash = hashCode(word.charAt(0)), hashSub = hashCode(sub);
        int lenSub = sub.length(), left = 0;

        if (hash == hashSub) ans.add(left);

        for (int i = 1; i < word.length(); i++) {

            if (hash == hashSub && isAnagram(word.substring(left, i + 1), sub)) ans.add(left);

            char newChar = word.charAt(i);
            char oldChar = word.charAt(left);

            if (i < lenSub) hash += hashCode(newChar);
            else {
                hash = changeHash(hash, oldChar, newChar);
                left++;
            }
            if (hash == hashSub && isAnagram(word.substring(left, i + 1), sub)) ans.add(left);
        }
        return ans;
    }

    private static int changeHash(int hash, char oldChar, char newChar) {
        hash -= hashCode(oldChar);
        hash += hashCode(newChar);
        return hash;
    }

    private static int hashCode(char c) {
        return 31 * c;
    }

    private static int hashCode(String s) {
        int hash = 0;
        for (char c : s.toCharArray()) hash += hashCode(c);
        return hash;
    }

    private static boolean isAnagram(String s, String p) {
        if (s.length() != p.length()) return false;
        int store[] = new int[26];
        for (char c : s.toCharArray()) store[c - 'a']++;
        for (char c : p.toCharArray()) store[c - 'a']--;
        for (int i : store) {
            if (i != 0) return false;
        }
        return true;
    }
}