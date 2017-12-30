package timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HistoryExam_1196 {
    public static void main(String[] args) throws IOException {

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        int n = Integer.parseInt(bufferedReader.readLine()), a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(bufferedReader.readLine());
        }
        int m = Integer.parseInt(bufferedReader.readLine()), b[] = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(bufferedReader.readLine());
        }
        System.out.println(estimateMark(a, b));
        inputStreamReader.close();
        bufferedReader.close();
    }

    public static int estimateMark(int a[], int b[]){
        int counter = 0;
        for (int i = 0; i < b.length; i++) {
            if (Arrays.binarySearch(a, 0, a.length, b[i]) >= 0) {
                counter++;
            }
        }
        return counter;
    }
}
