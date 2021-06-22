package leetcode_problems.easy;

public class CrawlerLogFolder_1598 {

    public int minOperations(String[] logs) {
        int count = 0;

        for (String log : logs) {
            if (log.equals("../") && count > 0) count--;
            else if (!log.equals("../") && !log.equals("./")) count++;
        }
        return count;
    }
}
