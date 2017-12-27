package interviews;

/*
Note that question given in google interview

Given a contiguous sequence of numbers in which each number repeats thrice,
there is exactly one missing number. Find the missing number.
eg: 11122333 : Missing number 2
11122233344455666 Missing number 5
 */
public class MissingNumber {
    public static int missingNumber(int arr[]) {
        int i = 1, count = 1;
        while (i < arr.length) {
            if (arr[i] == arr[i - 1]) count++;
            else {
                if (count != 3) return arr[i - 1];
                else {
                    count = 1;
                }
            }
            i++;
        }
        return count != 3 ? arr[arr.length - 1] : -1;
    }
}