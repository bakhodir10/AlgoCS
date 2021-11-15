package leetcode_problems.medium;

// Space complexity: O(n)
public class DesignTicTacToe1_348 {

    private final int[] rows;
    private final int[] cols;
    private int diagonal;
    private int antiDiagonal;

    public DesignTicTacToe1_348(int n) {
        this.rows = new int[n];
        this.cols = new int[n];
    }

    // Time complexity: O(1)
    public int move(int row, int col, int player) {
        int playerMove = player == 1 ? 1 : -1;

        rows[row] += playerMove;
        cols[col] += playerMove;

        if (row == col) diagonal += playerMove;
        if (col == cols.length - row - 1) antiDiagonal += playerMove;

        int n = rows.length;
        return Math.abs(rows[row]) == n
                || Math.abs(cols[col]) == n
                || Math.abs(diagonal) == n
                || Math.abs(antiDiagonal) == n
                ? player : 0;
    }
}
