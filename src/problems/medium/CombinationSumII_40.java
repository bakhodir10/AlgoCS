package problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// todo not finished
public class CombinationSumII_40 {
    public static void main(String[] args) {
        combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
//        combinationSum2(new int[]{2, 5, 2, 1, 2}, 5);
    }

    public static List<List<Integer>> combinationSum2(int candidates[], int target) {

        List<List<Integer>> ans = new ArrayList<>();
        if (candidates.length == 0) return ans;
        Arrays.sort(candidates);

        for (int i = 0; i < Math.pow(2, candidates.length); i++) {
            String s = Integer.toBinaryString(i);
            List<Integer> list = getSubsetSum(candidates, s, target);
            if (list != null) {
//                if (!isExist(ans, list))
                    ans.add(list);
            }
        }
        for (List<Integer> l : ans) System.out.println(l);

        return ans;
    }

    private static boolean isExist(List<List<Integer>> allList, List<Integer> list) {
        for (List<Integer> one : allList) {
            if (one.equals(list)) return true;
        }
        return false;
    }

    private static List<Integer> getSubsetSum(int candidates[], String s, int target) {
        for (int i = s.length(); i < candidates.length; i++) s = "0".concat(s);
        List<Integer> ans = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                sum += candidates[i];
                ans.add(candidates[i]);
            }
        }
        return sum == target ? ans : null;
    }

}
