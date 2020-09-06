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
            for (String product : products) {
                if (suggestedThree.size() == 3) break;
                if (product.startsWith(searchWord.substring(0, i + 1))) suggestedThree.add(product);
            }
            suggestedWords.add(suggestedThree);
        }
        return suggestedWords;
    }
}