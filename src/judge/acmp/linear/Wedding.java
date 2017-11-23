package judge.acmp.linear;

import java.util.Scanner;

public class Wedding {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        Double a[] = new Double[x.nextInt()];
        for (int i = 0; i < a.length; i++) {
            a[i] = x.nextDouble();
        }
        mergeSort(a);
        double money = x.nextDouble();

        for (int i = 0; i < a.length; i++) {
            if(money < a[i]) money = (money + a[i]) / 2;
        }
        System.out.format("%.6f%n", money);
    }

    public static void mergeSort(Comparable [ ] a)
    {
        Comparable[] tmp = new Comparable[a.length];
        mergeSort(a, tmp,  0,  a.length - 1);
    }


    private static void mergeSort(Comparable [ ] a, Comparable [ ] tmp, int left, int right)
    {
        if( left < right )
        {
            int center = (left + right) / 2;
            mergeSort(a, tmp, left, center);
            mergeSort(a, tmp, center + 1, right);
            merge(a, tmp, left, center + 1, right);
        }
    }


    private static void merge(Comparable[ ] a, Comparable[ ] tmp, int left, int right, int rightEnd )
    {
        int leftEnd = right - 1;
        int k = left;
        int num = rightEnd - left + 1;

        while(left <= leftEnd && right <= rightEnd)
            if(a[left].compareTo(a[right]) <= 0)
                tmp[k++] = a[left++];
            else
                tmp[k++] = a[right++];

        while(left <= leftEnd)    // Copy rest of first half
            tmp[k++] = a[left++];

        while(right <= rightEnd)  // Copy rest of right half
            tmp[k++] = a[right++];

        // Copy tmp back
        for(int i = 0; i < num; i++, rightEnd--)
            a[rightEnd] = tmp[rightEnd];
    }
}
