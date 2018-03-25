package problems;

// not done
class WordSearch_79 {
    public boolean exist(char[][] board, String word) {
        int[] a = findPos(board, word.charAt(0), 0, 0);
        if (a == null) return false;
        int i = a[0], j = a[1], oldI = i, oldJ = j, n = board.length, m = board[0].length, k = 1;
        boolean b[][] = new boolean[n][m];
        while (k < word.length()) {
            // second case -> backward
            if (j - 1 >= 0) {
                if (word.charAt(k) == board[i][j - 1] && !b[i][j - 1]) {
                    k++;
                    b[i][j] = true;
                    j--;
                    continue;
                }
            }
            // first case -> forward
            if (j + 1 < m) {
                if (word.charAt(k) == board[i][j + 1] && !b[i][j + 1]) {
                    k++;
                    b[i][j] = true;
                    j++;
                    continue;
                }
            }
            // fourth case -> downward
            if (i - 1 >= 0) {
                if (word.charAt(k) == board[i - 1][j] && !b[i - 1][j]) {
                    k++;
                    b[i][j] = true;
                    i--;
                    continue;
                }
            }
            // third case -> upward
            if (i + 1 < n) {
                if (word.charAt(k) == board[i + 1][j] && !b[i + 1][j]) {
                    k++;
                    b[i][j] = true;
                    i++;
                    continue;
                }
            }
            int ar[] = findPos(board, word.charAt(0), oldI, oldJ + 1);
            if (ar == null) return false;
            else {
                i = ar[0];
                j = ar[1];
                oldI = i;
                oldJ = j;
                k = 1;
                b = new boolean[n][m];
            }
        }
        return k == word.length();
    }

    private int[] findPos(char[][] m, char c, int fromI, int fromJ) {
        if (fromJ >= m[0].length) {
            fromI++;
            fromJ = 0;
        }
        for (int i = fromI; i < m.length; i++) {
            for (int j = fromJ; j < m[i].length; j++) {
                if (m[i][j] == c) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
/*
[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
"SEE"
true
 */