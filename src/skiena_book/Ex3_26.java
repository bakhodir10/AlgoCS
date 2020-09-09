package skiena_book;

public class Ex3_26 {

    public static String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) sb.append(words[i]);
        return sb.toString();
    }
}