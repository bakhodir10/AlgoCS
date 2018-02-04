package problems.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// todo not done
public class GroupAnagrams_49 {
    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new LinkedList<>();
        if (strs.length == 0) return list;
        List<String> sList = new LinkedList<>(Arrays.asList(strs));

        for (int i = 0; i < sList.size(); i++) {
            List<String> l = new LinkedList<>();
            l.add(sList.get(i));
            for (int j = i; j < sList.size(); j++) {
                if (findAnagrams(sList.get(i), sList.get(j))) {
                    l.add(sList.get(j));
                    sList.remove(sList.get(j));
                }
            }
            list.add(l);
        }
        return list;
    }

    private static boolean findAnagrams(String a, String b) {
        int c[] = new int[26];
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++) c[a.charAt(i) - 'a']++;
        for (int i = 0; i < b.length(); i++) c[b.charAt(i) - 'a']--;
        for (int i = 0; i < a.length(); i++) if (c[a.charAt(i) - 'a'] != 0) return false;
        return true;
    }
}
