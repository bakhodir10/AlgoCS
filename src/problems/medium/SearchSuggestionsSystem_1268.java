package problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SearchSuggestionsSystem_1268 {

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> suggestedWords = new LinkedList<>();
        if (products == null) return suggestedWords;
        Arrays.sort(products);

        for (int i = 0; i < searchWord.length(); i++) {
            List<String> suggestedThree = new ArrayList<>(3);
            String term = searchWord.substring(0, i + 1);
            for (String product : products) {
                if (suggestedThree.size() == 3) break;
                if (product.startsWith(term)) suggestedThree.add(product);
            }
            if (suggestedThree.size() != 0) suggestedWords.add(suggestedThree);
            else {
                while (i < searchWord.length()) {
                    suggestedWords.add(new ArrayList<>());
                    i++;
                }
            }
        }
        return suggestedWords;
    }
}