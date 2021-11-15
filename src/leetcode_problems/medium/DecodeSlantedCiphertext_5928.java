package leetcode_problems.medium;

public class DecodeSlantedCiphertext_5928 {

    // Time complexity: O(rows * columns). Memory complexity: O(rows * columns)
    public String decodeCiphertext(String encodedText, int rows) {
        if (encodedText.isEmpty()) return "";

        char[][] matrix = new char[rows][encodedText.length() / rows];
        int idx = 0, k = 0;

        while (idx < encodedText.length()) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[k][j] = encodedText.charAt(idx++);
            }
            k++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (j + i < matrix[0].length) sb.append(matrix[j][j + i]);
            }
        }
        while (sb.charAt(sb.length() - 1) == ' ') sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}
