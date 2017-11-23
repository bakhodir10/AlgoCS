package judge.timus;

import java.util.Scanner;

// not accepted

public class Maze_1642 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        int n = x.nextInt(), k = x.nextInt(), a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = x.nextInt();
        }
        calculateWays(k, a);
    }

    public static int calculateWays(int x, int a[]) {
        int exit = 0, obstacle = 0, counter = 0;
        for (int i = 0; i <= 1000; i++) {
            if (i < a.length) {
                System.out.println(i);
                if (i == x) exit = counter;
                if (i == a[i]) obstacle = counter;
                else if (i != x && i != a[i]) counter++;
            } else break;
        }

//        System.out.println(obstacle);
//        System.out.println(exit);

//        int start = exit != 0 ? exit : obstacle;
//
//        for (int i = start; i >= -1000; i--) {
//            if (Math.abs(i) < a.length) {
//                System.out.println(i);
//                if (i == x) exit = counter;
//                if (i == a[Math.abs(i)]) obstacle = counter;
//                else if (i != x && i != a[Math.abs(i)]) counter++;
//            } else break;
//        }
//        System.out.println(obstacle);
//        System.out.println(exit);

//
//        for (int i = 0; i > -1000; i--) {
//            if (Math.abs(i) < a.length) {
//                if (i != x && !ex) {
//                    exit++;
//                }
//                if (i != a[Math.abs(i)] && !obst) {
//                    obstacle++;
//                }
//                else break;
//            }
//        }
        return 0;
    }
}
