package problems.hard;

public class MinimumWindowSubstring_76 {

    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        int min = Integer.MAX_VALUE, startIndex = 0, endIndex = 0, slow = 0;
        int counter = t.length();
        int[] arr = new int[128];

        for (char c : t.toCharArray()) arr[c]++;

        for (int fast = 0; fast < s.length(); fast++) {
            if (arr[s.charAt(fast)]-- > 0) counter--;
            while (counter == 0) {
                if (fast - slow < min) {
                    startIndex = slow;
                    endIndex = fast;
                    min = fast - slow;
                }
                arr[s.charAt(slow)]++;

                if (arr[s.charAt(slow++)] > 0) counter++;
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(startIndex, endIndex + 1);
    }
}
