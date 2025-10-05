package leetcode_problems.hard;

import java.util.ArrayDeque;
import java.util.Deque;

public class DesignATextEditor_2296 {

    // Approach 1. Using Deque

    private final Deque<Character> left;
    private final Deque<Character> right;

    public DesignATextEditor_2296() {
        this.left = new ArrayDeque<>();
        this.right = new ArrayDeque<>();
    }

    public void addText(String text) {
        for(int i = 0; i < text.length(); i ++) {
            left.addLast(text.charAt(i));
        }
    }

    public int deleteText(int k) {
        int deleted = 0;
        while(!left.isEmpty() && k > deleted) {
            left.removeLast();
            deleted++;
        }
        return deleted;
    }

    public String cursorLeft(int k) {
        while(!left.isEmpty() && k-- > 0) {
            right.addFirst(left.removeLast());
        }
        return getLast10Chars();
    }

    public String cursorRight(int k) {
        while(!right.isEmpty() && k-- > 0) {
            left.addLast(right.removeFirst());
        }
        return getLast10Chars();
    }

    private String getLast10Chars() {
        StringBuilder res = new StringBuilder();
        while(!left.isEmpty() && res.length() < 10) {
            res.append(left.removeLast());
        }
        res.reverse();
        for(int i = 0; i < res.length(); i++) left.addLast(res.charAt(i));
        return res.toString();
    }

 /*
    2nd approach. Using just StringBuilder

    private int cursor;
    private StringBuilder word;

    public DesignATextEditor_2296() {
        this.cursor = 0;
        this.word = new StringBuilder();
    }

    public void addText(String text) {
        word.insert(cursor, text);
        cursor += text.length();
    }

    public int deleteText(int k) {
        int deleted = 0;
        for(int i = cursor - 1; i >= 0 && k > 0; i--) {
            word.deleteCharAt(i);
            deleted++;
            k--;
            cursor--;
        }
        return deleted;
    }

    public String cursorLeft(int k) {
        StringBuilder sub = new StringBuilder();
        cursor = Math.max(0, cursor - k);
        int idx = cursor - 1;
        while(sub.length() < 10 && idx >= 0) {
            sub.append(word.charAt(idx));
            idx--;
        }
        return sub.reverse().toString();
    }

    public String cursorRight(int k) {
        StringBuilder sub = new StringBuilder();
        cursor = Math.min(word.length(), cursor + k);
        int idx = cursor - 1;
        while(sub.length() < 10 && idx >= 0) {
            sub.append(word.charAt(idx));
            idx--;
        }
        return sub.reverse().toString();
    }
  */
}
