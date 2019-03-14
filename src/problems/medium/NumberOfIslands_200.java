package problems.medium;

import java.util.LinkedList;
import java.util.Queue;

// todo not done
public class NumberOfIslands_200 {

    public static void main(String[] args) {
        char c[][] = new char[4][5];
        c[0] = "11110".toCharArray();
        c[1] = "11010".toCharArray();
        c[2] = "11000".toCharArray();
        c[3] = "00000".toCharArray();
        numIslands(c);
    }

    public static int numIslands(char[][] c) {
        boolean[][] visited = new boolean[c.length][c[0].length];
        int i = 0, j = 0, count = 0;

        while (i < c.length && j < c[0].length && !visited[i][j]) {

//            if ()
            i++;
            j++;
        }
        Queue<Integer> q = new LinkedList<>();
//        q.add();
        return 0;
    }
}