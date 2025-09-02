package leetcode_problems.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InvalidTransactions_1169 {

    public record Transaction(int time, int amount, String city, int idx) {}

    // Time complexity: O(n)
    // Space complexity: O(n)
    public List<String> invalidTransactions(String[] transactions) {
        boolean[] invalid = new boolean[transactions.length];
        Map<String, List<Transaction>> byName = new HashMap<>();
        List<String> result = new ArrayList<>();

        for (int i = 0; i < transactions.length; i++) {
            String[] record = transactions[i].split(",");
            String name = record[0];
            int time = Integer.parseInt(record[1]);
            int amount = Integer.parseInt(record[2]);
            String city = record[3];

            List<Transaction> list = byName.getOrDefault(name, new ArrayList<>());
            list.add(new Transaction(time, amount, city, i));
            byName.put(name, list);
        }

        for (List<Transaction> list : byName.values()) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).amount > 1000) {
                    invalid[list.get(i).idx] = true;
                }

                for (int j = i + 1; j < list.size(); j++) {
                    if (Math.abs(list.get(i).time - list.get(j).time) <= 60 &&
                            !list.get(i).city.equals(list.get(j).city)) {
                        invalid[list.get(i).idx] = true;
                        invalid[list.get(j).idx] = true;
                    }
                }
            }
        }

        for (int i = 0; i < invalid.length; i++) {
            if (invalid[i]) result.add(transactions[i]);
        }
        return result;
    }
}
