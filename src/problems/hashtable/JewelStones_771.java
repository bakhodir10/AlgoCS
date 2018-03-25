package problems.hashtable;

public class JewelStones_771 {
    public static int numJewelsInStones(String j, String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (j.contains(c + "")) count++;
        }
        return count;
    }
}