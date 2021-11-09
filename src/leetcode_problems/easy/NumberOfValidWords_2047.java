package leetcode_problems.easy;

public class NumberOfValidWords_2047 {

    // Time complexity: O(count of words * max(word.length)). Space complexity: O(count of words)
    public int countValidWords(String sentence) {
        String[] strs = sentence.split(" ");
        int count = 0;

        for (String s : strs) {
            if (validate(s.trim().toCharArray())) count++;
        }
        return count;
    }

    private boolean validate(char[] chars) {
        if (chars.length == 0) return false;
        if (chars.length == 1 && (chars[0] == '!' || chars[0] == '.' || chars[0] == ',')) return true;
        if (chars[0] == '-' || chars[chars.length - 1] == '-' || chars[0] == '!' || chars[0] == '.' || chars[0] == ',') return false;

        int puncs = 0;
        int dashes = 0;
        int index = 0;

        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) return false;
            if (chars[i] == '!' || chars[i] == '.' || chars[i] == ',') puncs++;
            if (chars[i] == '-') {
                dashes++;
                index = i;
            }
        }

        if (puncs > 1) return false;
        if (dashes > 1) return false;

        if (dashes > 0 && chars[0] == '-' || chars[chars.length - 1] == '-') return false;
        if (dashes == 1) {
            if (!Character.isLowerCase(chars[index - 1]) || !Character.isLowerCase(chars[index + 1])) return false;
        }

        if (puncs == 1) {
            char last = chars[chars.length - 1];
            return last == '!' || last == '.' || last == ',';
        }
        return true;
    }
}
