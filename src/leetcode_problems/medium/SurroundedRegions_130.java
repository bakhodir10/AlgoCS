package leetcode_problems.medium;

public class SurroundedRegions_130 {

    public void solve(char[][] board) {
        if (board.length == 0) return;

        // top(0, j): left to right
        for (int j = 0; j < board[0].length; j++) {
            if (board[0][j] == 'O') coloring(board, 0, j);
        }
        // left(i, 0): up to bottom
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') coloring(board, i, 0);
        }
        // down(n - 1, j): left to right
        for (int j = 0; j < board[0].length; j++) {
            if (board[board.length - 1][j] == 'O') coloring(board, board.length - 1, j);
        }
        // right(i, n - 1): up to bottom
        for (int i = 0; i < board.length; i++) {
            if (board[i][board[0].length - 1] == 'O') coloring(board, i, board[0].length - 1);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'Y') board[i][j] = 'O';
            }
        }
    }

    private void coloring(char[][] board, int i, int j) {
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[i].length - 1) {
            return;
        }

        board[i][j] = 'Y';

        if (i > 0 && board[i - 1][j] == 'O') coloring(board, i - 1, j);
        if (i < board.length - 1 && board[i + 1][j] == 'O') coloring(board, i + 1, j);
        if (j > 0 && board[i][j - 1] == 'O') coloring(board, i, j - 1);
        if (j < board[i].length - 1 && board[i][j + 1] == 'O') coloring(board, i, j + 1);
    }
}
