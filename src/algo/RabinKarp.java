package algo;

public class RabinKarp {
    
    public static boolean rabinKarp(String word, String sub) {

        int hash = hashCode(word.charAt(0)), hashSub = hashCode(sub);
        int lenSub = sub.length(), left = 0;

        for (int i = 1; i < word.length(); i++) {

            if (hash == hashSub) return true;

            char newChar = word.charAt(i);
            char oldChar = word.charAt(left);

            if (i < lenSub) hash += hashCode(newChar);
            else {
                hash = changeHash(hash, oldChar, newChar);
                left++;
            }
        }
        return hash == hashSub;
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
}
