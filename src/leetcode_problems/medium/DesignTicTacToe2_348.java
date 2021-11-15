package leetcode_problems.medium;

// Space complexity: O(n^2)
public class DesignTicTacToe2_348 {

    private final int n;
    private final int[][] board;


    public DesignTicTacToe2_348(int n) {
        this.board = new int[n][n];
        this.n = n;
    }

    // Time complexity: O(n)
    public int move(int row, int col, int player) {
        board[row][col] = player;

        return checkRow(row, player)
                || checkCol(col, player)
                || checkDiagonal(player)
                || checkAntiDiagonal(player)
                ? player : 0;
    }

    private boolean checkRow(int row, int player) {
        for (int col = 0; col < board.length; col++) {
            if (board[row][col] != player) return false;
        }
        return true;
    }

    private boolean checkCol(int col, int player) {
        for (int row = 0; row < board.length; row++) {
            if (board[row][col] != player) return false;
        }
        return true;
    }

    private boolean checkDiagonal(int player) {
        for (int row = 0; row < board.length; row++) {
            if (board[row][row] != player) return false;
        }
        return true;
    }

    private boolean checkAntiDiagonal(int player) {
        for (int row = 0; row < board.length; row++) {
            if (board[row][n - row - 1] != player) return false;
        }
        return true;
    }
}
