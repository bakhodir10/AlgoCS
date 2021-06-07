package problems.easy;

public class SingleRowKeyboard_1165 {

    // Time complexity: O(n). Space complexity: O(1)
    public int calculateTime(String keyboard, String word) {

        int[] arr = new int[26];
        for (int i = 0; i < keyboard.length(); i++) arr[keyboard.charAt(i) - 'a'] = i;

        int i = 0, total = 0;
        for (char c : word.toCharArray()) {
            int j = arr[c - 'a'];
            total += Math.abs(j - i);
            i = j;
        }
        return total;
    }
}
