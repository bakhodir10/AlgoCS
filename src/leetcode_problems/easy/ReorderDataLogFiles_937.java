package leetcode_problems.easy;

import java.util.ArrayList;
import java.util.List;

public class ReorderDataLogFiles_937 {

    // Approach 1. Time complexity: O(n). Space complexity: O(n)
    public String[] reorderLogFiles1(String[] logs) {
        List<String[]> letterLogs = new ArrayList<>();
        List<String> numberLogs = new ArrayList<>();

        for (String log : logs) {
            String identifier = log.split(" ")[0];
            String content = log.substring(identifier.length() + 1);

            if (isDigit(content)) numberLogs.add(log);
            else letterLogs.add(new String[]{identifier, content});
        }

        letterLogs.sort((e1, e2) -> {
            if (e1[1].equals(e2[1])) return e1[0].compareTo(e2[0]);
            else return e1[1].compareTo(e2[1]);
        });

        int k = 0;
        String[] reorderedLogs = new String[logs.length];

        for (String[] log : letterLogs) reorderedLogs[k++] = log[0] + " " + log[1];
        for (String log : numberLogs) reorderedLogs[k++] = log;

        return reorderedLogs;
    }

    // Approach 2. Time complexity: O(n). Space complexity: O(n)
    public String[] reorderLogFiles2(String[] logs) {
        List<String> letterLogs = new ArrayList<>();
        List<String> numberLogs = new ArrayList<>();

        for (String log : logs) {
            if (isDigit(log)) numberLogs.add(log);
            else letterLogs.add(log);
        }

        letterLogs.sort((e1, e2) -> {
            String word1 = e1.substring(e1.indexOf(" ") + 1);
            String word2 = e2.substring(e2.indexOf(" ") + 1);

            if (word1.equals(word2)) return e1.compareTo(e2);
            else return word1.compareTo(word2);
        });

        letterLogs.addAll(numberLogs);
        return letterLogs.toArray(String[]::new);
    }


    private boolean isDigit(String s) {
        return Character.isDigit(s.charAt(s.length() - 1));
    }
}
