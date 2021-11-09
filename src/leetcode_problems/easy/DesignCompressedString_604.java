package leetcode_problems.easy;

import java.util.ArrayList;
import java.util.List;

public class DesignCompressedString_604 {

    private int idx = 0;
    private int total = 0;
    private char[] chars;
    private List<Tuple> list;

    // Time complexity: O(n). Space complexity: O(n)
    public DesignCompressedString_604(String s) {
        this.list = new ArrayList<>();
        this.chars = s.toCharArray();

        int i = 0;
        while (i < chars.length) {
            char c = chars[i];
            int num = 0;
            i++;
            while (i < chars.length && Character.isDigit(chars[i])) {
                num = num * 10 + chars[i++] - '0';
            }
            total += num;
            list.add(new Tuple(c, num));
        }
    }

    // Time complexity: O(1)
    public char next() {
        if (total <= 0) return ' ';

        Tuple tuple = list.get(idx);
        tuple.count--;
        total--;

        if (tuple.count == 0) idx++;
        return tuple.c;
    }

    // Time complexity: O(1)
    public boolean hasNext() {
        return total > 0;
    }

    private static class Tuple {
        private final char c;
        private int count;

        public Tuple(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }
}
