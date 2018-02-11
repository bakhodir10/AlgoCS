package problems.medium;

// todo not finished
@SuppressWarnings("Duplicates")
public class MultiplyStrings_43 {
    public static void main(String[] args) {
        System.out.println(multiply("0", "123"));
    }

    public static String multiply(String num1, String num2) {
        String result = "";
        int k = 0;
        for (int i = num2.length() - 1; i >= 0; i--) {
            int remainder = 0;
            StringBuilder temp = new StringBuilder();
            for (int j = num1.length() - 1; j >= 0; j--) {
                int value = (num2.charAt(i) - '0') * (num1.charAt(j) - '0') + remainder;
                remainder = value / 10;
                temp.insert(0, value % 10);
            }
            if (remainder != 0) temp.insert(0, remainder);
            result = "0".concat(result);
            for (int j = 0; j < k; j++) {
                temp.append(0);
            }
            k++;
            result = result.equals("0") ? temp.toString() : addingTwoStrNumbers(result, temp.toString());
        }
        return result;
    }

    private static String addingTwoStrNumbers(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int remainder = 0;
        for (int i = num1.length() - 1; i >= 0; i--) {
            int value = num1.charAt(i) - '0' + num2.charAt(i) - '0' + remainder;
            result.insert(0, String.valueOf(value % 10));
            remainder = value / 10;
        }
        if (remainder == 1) result.insert(0, remainder);
        return result.toString();
    }
}