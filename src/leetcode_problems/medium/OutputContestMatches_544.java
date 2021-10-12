package leetcode_problems.medium;

public class OutputContestMatches_544 {

    // Time complexity: O(n^2). Space complexity: O(n)
    public String findContestMatch(int n) {
        String[] arr = new String[n];

        for (int i = 0; i < arr.length / 2; i++) {
            arr[i] = String.valueOf(i + 1);
            arr[arr.length - 1 - i] = String.valueOf(arr.length - i);
        }

        while (arr.length > 1) {
            String[] newArr = new String[arr.length / 2];

            for (int i = 0; i < arr.length / 2; i++) {
                StringBuilder sb = new StringBuilder();
                sb.append("(").append(arr[i]).append(",").append(arr[arr.length - i - 1]).append(")");
                newArr[i] = sb.toString();
            }
            arr = newArr;
        }
        return arr[0];
    }
}
