package leetcode_problems.medium;

import java.util.*;

public class DesignSQL_2408 {

    // HashMap<name, List<List<columns>>> tables
    private final Map<String, List<List<String>>> tables;
    // Map<name, Set<rowId>> deletedRows
    private final Map<String, Set<Integer>> deletedRows;

    public DesignSQL_2408(List<String> names, List<Integer> columns) {
        this.tables = new HashMap<>();
        this.deletedRows = new HashMap<>();

        for(int i = 0; i < names.size(); i ++) {
            List<String> column0 = new ArrayList<>();
            for (int j = 0; j < columns.get(i); j++) column0.add("*");
            tables.computeIfAbsent(names.get(i),
                    k -> new ArrayList<>()).add(column0);
            deletedRows.computeIfAbsent(names.get(i), k -> new HashSet<>()).add(0);
        }
    }

    public boolean ins(String name, List<String> row) {
        if(!tables.containsKey(name)) return false;

        List<List<String>> rows = tables.get(name);
        if(row.size() != rows.getFirst().size()) return false;

        rows.add(new ArrayList<>(row));
        return true;
    }

    // Map<name, Set<rowId>> deletedRows
    public void rmv(String name, int rowId) {
        if(!tables.containsKey(name)) return;

        List<List<String>> rows = tables.get(name);
        if(rowId < 0 || rows.size() <= rowId) return;

        deletedRows.get(name).add(rowId);
    }

    public String sel(String name, int rowId, int columnId) {
        if(!tables.containsKey(name)) return "<null>";

        List<List<String>> rows = tables.get(name);
        if(rows.size() <= rowId || rows.getFirst().size() < columnId) return "<null>";
        if(deletedRows.get(name).contains(rowId)) return "<null>";

        if (rowId <= 0 || rowId >= rows.size()) return "<null>";
        if (columnId <= 0 || columnId > rows.get(0).size()) return "<null>";

        return rows.get(rowId).get(columnId - 1);
    }

    public List<String> exp(String name) {
        if(!tables.containsKey(name)) return Collections.emptyList();

        Set<Integer> deleted = deletedRows.get(name);
        List<List<String>> rows = tables.get(name);
        List<String> result = new ArrayList<>();

        for(int i = 0; i < rows.size(); i ++) {
            if(deleted.contains(i)) continue;

            List<String> row = rows.get(i);
            StringBuilder sb = new StringBuilder(String.valueOf(i));
            for (String s : row) sb.append(",").append(s);
            result.add(sb.toString());
        }
        return result;
    }
}
