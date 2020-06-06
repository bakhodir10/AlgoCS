package problems.medium;

// Robin-Karp algorithm. Time complexity: O(N). The worst case O(N*M). Memory: O(1)
public class PermutationInString_567 {

    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) return false;

        int s1Length = s1.length();
        int s2Length = s2.length();
        long s1Hash = createHash(s1);
        long s2Hash = createHash(s2.substring(0, s1Length));

        if (s1Hash == s2Hash && isPermutation(s1, s2.substring(0, s1Length))) return true;

        for (int i = 1; i + s1Length <= s2Length; i++) {
            s2Hash = regenerateHash(s2.charAt(i - 1), s2.charAt(i + s1Length - 1), s2Hash);
            if (s1Hash == s2Hash && isPermutation(s1, s2.substring(i, i + s1Length))) return true;
        }

        return false;
    }

    private long createHash(String s) {
        long hashCode = 0;
        for (char c : s.toCharArray()) hashCode += (c - 'a' + 1) * (c - 'a' + 1);
        return hashCode;
    }

    private long regenerateHash(char left, char right, long hash) {
        return hash - (left - 'a' + 1) * (left - 'a' + 1) + (right - 'a' + 1) * (right - 'a' + 1);
    }

    private boolean isPermutation(String s1, String s2) {
        int[] arr = new int[26];

        for (char c : s1.toCharArray()) arr[c - 'a']++;
        for (char c : s2.toCharArray()) arr[c - 'a']--;

        for (int num : arr) {
            if (num != 0) return false;
        }
        return true;
    }
}
