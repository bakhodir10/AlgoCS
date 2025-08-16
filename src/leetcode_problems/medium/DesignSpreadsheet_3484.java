package leetcode_problems.medium;

import java.util.Arrays;

public class DesignSpreadsheet_3484 {

    private final int[][] rows;

    public DesignSpreadsheet_3484(int rowsCount) {
        this.rows = new int[26][rowsCount + 1];
        for (int[] row : rows) Arrays.fill(row, 0);
    }

    public void setCell(String cell, int value) {
        int i = cell.charAt(0) - 'A';
        int j = Integer.parseInt(cell.substring(1));
        rows[i][j] = value;
    }

    public void resetCell(String cell) {
        int i = cell.charAt(0) - 'A';
        int j = Integer.parseInt(cell.substring(1));
        rows[i][j] = 0;
    }

    public int getValue(String formula) {
        int val1, val2;
        int plusIndex = formula.indexOf("+");

        if(formula.charAt(1) >= '0' && formula.charAt(1) <= '9') {
            val1 = Integer.parseInt(formula.substring(1, plusIndex));
        } else {
            int i = formula.charAt(1) - 'A';
            int j = Integer.parseInt(formula.substring(2, plusIndex));
            val1 = rows[i][j];
        }

        if(formula.charAt(plusIndex + 1) >= '0' && formula.charAt(plusIndex + 1) <= '9') {
            val2 = Integer.parseInt(formula.substring(plusIndex + 1));
        } else {
            int i = formula.charAt(plusIndex + 1) - 'A';
            int j = Integer.parseInt(formula.substring(plusIndex + 2));
            val2 = rows[i][j];
        }

        return val1 + val2;
    }
}
