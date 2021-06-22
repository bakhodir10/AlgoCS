package leetcode_problems.easy;

public class RearrangeSpaces_5519 {

    public String reorderSpaces(String text) {
        int spaceCount = 0;
        String[] words = text.trim().split("\\s+");
        int wordCount = words.length;

        for (char c : text.toCharArray()) {
            if (c == ' ') spaceCount++;
        }

        int average = wordCount == 1 ? 0 : spaceCount / (wordCount - 1);
        int remainder = spaceCount - (wordCount - 1) * average;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            sb.append(words[i]);
            if (i != words.length - 1) {
                sb.append(" ".repeat(average));
            }
        }
        sb.append(" ".repeat(remainder));

        return sb.toString();
    }
}
