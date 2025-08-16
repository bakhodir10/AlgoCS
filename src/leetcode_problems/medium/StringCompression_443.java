package leetcode_problems.medium;

public class StringCompression_443 {

    public int compress(char[] chars) {
        int l = 0, r = 0, curr = 0, size = 0;

        while(r < chars.length) {
            int count = 0;
            while(r < chars.length && chars[l] == chars[r]) {
                r++;
                count++;
            }
            chars[curr++] = chars[l];
            if(count > 1) {
                int temp = count;
                int start = curr;

                while(temp != 0) {
                    chars[curr++] = (char) ('0' + (temp % 10));
                    temp /= 10;
                }
                int end = curr - 1;
                while(start < end) {
                    char swap = chars[start];
                    chars[start++] = chars[end];
                    chars[end--] = swap;
                }
            }
            l = r;
        }
        return curr;
    }

    // Time complexity: O(n)
    // Space complexity: O(n). Because of StringBuilder
    public int compress2(char[] chars) {
        StringBuilder sb = new StringBuilder();
        int l = 0, r = 0;

        while(r < chars.length) {
            int count = 0;
            while(r < chars.length && chars[l] == chars[r]) {
                r++;
                count++;
            }
            sb.append(chars[l]);
            if(count > 1) sb.append(count);
            l = r;
        }
        for(int i = 0; i < sb.length(); i ++) chars[i] = sb.charAt(i);
        return sb.length();
    }
}
