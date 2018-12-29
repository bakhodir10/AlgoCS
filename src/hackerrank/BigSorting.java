package hackerrank;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// todo not finished
@SuppressWarnings("Duplicates")
public class BigSorting {

    // Complete the bigSorting function below.
    private static String[] bigSorting(String[] unsorted) {
        List<String> list = Arrays.asList(unsorted);
        Collections.sort(list);
        return list.toArray(new String[0]);
    }

    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        int n = x.nextInt();
        String s[] = new String[n];

        for (int i = 0; i < n; i++) s[i] = x.next();
        s = bigSorting(s);
        for (String s1 : s) {
            System.out.println(s1);
        }
    }
}
