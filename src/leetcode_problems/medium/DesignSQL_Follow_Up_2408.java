package leetcode_problems.medium;

import java.util.*;

public class DesignSQL_Follow_Up_2408 {

    private static class Row {
        private final int rowId;
        private final int columnSize;
        private final List<String> cells;

        public Row(int rowId, int columnSize, List<String> row) {
            this.rowId = rowId;
            this.columnSize = columnSize;
            this.cells = new ArrayList<>(row);
        }

        public String getCell(int cellId) {
            if(cellId < 0 || cellId > this.columnSize) return "<null>";
            return cells.get(cellId - 1);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(String.valueOf(rowId));
            for (String cell : cells) sb.append(",").append(cell);
            return sb.toString();
        }
    }

    private static class Table {
        private final int numColumns;
        private final Map<Integer, Row> rows;
        private int currIdx;

        public Table(int numColumns) {
            this.numColumns = numColumns;
            this.rows = new HashMap<>();
            this.currIdx = 1;
        }

        public boolean insert(List<String> row) {
            if(row.size() != numColumns) return false;

            Row newRow = new Row(currIdx, numColumns, row);
            rows.put(currIdx, newRow);
            currIdx++;
            return true;
        }

        public void remove(int rowId) {
            rows.remove(rowId);
        }

        public String getCell(int rowId, int columnId) {
            Row row = rows.get(rowId);
            if(row == null) return "<null>";
            return row.getCell(columnId);
        }

        public List<String> export() {
            List<String> result = new ArrayList<>();
            for(Row row: rows.values()) result.add(row.toString());
            return result;
        }
    }

    private final Map<String, Table> tables;
    public DesignSQL_Follow_Up_2408(List<String> names, List<Integer> columns) {
        this.tables = new HashMap<>();
        for(int i = 0; i < names.size(); i ++) tables.put(names.get(i), new Table(columns.get(i)));
    }

    // Time complexity: O(1)
    public boolean ins(String name, List<String> row) {
        Table table = tables.get(name);
        if(table == null) return false;
        return table.insert(row);
    }

    // Time complexity: O(1)
    public void rmv(String name, int rowId) {
        Table table = tables.get(name);
        if(table == null) return;
        table.remove(rowId);
    }

    // Time complexity: O(1)
    public String sel(String name, int rowId, int columnId) {
        Table table = tables.get(name);
        if(table == null) return "<null>";
        return table.getCell(rowId, columnId);
    }

    // Time complexity: O(n)
    public List<String> exp(String name) {
        Table table = tables.get(name);
        if(table == null) return Collections.emptyList();
        return table.export();
    }
}
