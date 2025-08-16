package leetcode_problems.medium;

import java.util.Arrays;

public class RankTeamsByVotes_1366 {

    // Time complexity: O(nlogm)
    // Space complexity: O(n)
    public String rankTeams(String[] votes) {
        int len = votes[0].length();
        int[][] map = new int[26][len + 1]; // len + 1 for keeping the letter for reference

        for(int i = 0; i < 26; i++) map[i][len] = i;

        for (String vote : votes) {
            for (int j = 0; j < vote.length(); j++) {
                int row = vote.charAt(j) - 'A';
                map[row][j]++;
            }
        }

        // we should not sort the last letter or map. Therefore, use votes[0] instead of len
        Arrays.sort(map, (e1, e2) -> {
            for(int i = 0; i < votes[0].length(); i++){
                if(e1[i] != e2[i]) return e2[i] - e1[i];
            }
            return 0;
        });

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < votes[0].length(); i ++) sb.append((char)(map[i][len] + 'A'));
        return sb.toString();
    }}
