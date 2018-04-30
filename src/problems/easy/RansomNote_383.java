package problems.easy;

public class RansomNote_383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int arr[] = new int[26];
        for (char c : ransomNote.toCharArray()) arr[c - 'a']++;
        for (char c : magazine.toCharArray()) arr[c - 'a']--;
        for (int i : arr) {
            if (i > 0) return false;
        }
        return true;
    }
}