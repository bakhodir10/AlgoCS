package problems.easy;

public class ShortestDistanceCharacter_821 {

    // Time complexity: O(n). Space complexity: O(n)
    public int[] shortestToChar(String s, char c) {
        int[] ans = new int[s.length()];
        int closest = Integer.MAX_VALUE;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) closest = i;
            ans[i] = Math.abs(i - closest);
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == c) closest = i;
            ans[i] = Math.min(ans[i], Math.abs(i - closest));
        }

        return ans;
    }
}
