package codeforces;

import java.util.Scanner;

public class StringTask_118A {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        StringBuilder s = new StringBuilder(x.next());
        s = makeLowerCase(s);
        s = deleteVowels(s);
        s = insertDots(s);
        System.out.println(s);
    }

    public static StringBuilder deleteVowels(StringBuilder text){
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == 'a' || text.charAt(i) == 'e' || text.charAt(i) == 'i' || text.charAt(i) == 'o' || text.charAt(i) == 'u'
                    || text.charAt(i) == 'y') {
                text.delete(i, i + 1);
                i--;
            }
        }
        return text;
    }

    public static StringBuilder insertDots(StringBuilder text){
        StringBuilder newWord = new StringBuilder(text.length() * 2);
        for (int i = 0; i < text.length(); i++) {
            newWord.append('.').append(text.charAt(i));
        }
        return newWord;
    }

    public static StringBuilder makeLowerCase(StringBuilder text){
        return new StringBuilder(text.toString().toLowerCase());
    }

}
