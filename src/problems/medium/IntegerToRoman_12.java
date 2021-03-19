package problems.medium;

public class IntegerToRoman_12 {

    // Time complexity: O(1). Space complexity: O(1)
    public String intToRoman(int num) {
        StringBuilder roman = new StringBuilder();
        final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        final String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        for (int i = 0; i < values.length && num > 0; i++) {
            while (values[i] <= num) {
                num -= values[i];
                roman.append(symbols[i]);
            }
        }
        return roman.toString();
    }
}
