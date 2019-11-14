package problems.medium;

/*
 This question took me a year to solve. I am glad, finally I solved it :-)
*/

class WordSearch_79 {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        char[] c = word.toCharArray();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == c[0] && dfs(board, i, j, c, 0, visited)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, char[] c, int k, boolean[][] visited) {
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[i].length - 1
                || visited[i][j] || board[i][j] != c[k]) {
            return false;
        }

        if (k == c.length - 1) return true;
        visited[i][j] = true;
        boolean isFound = dfs(board, i + 1, j, c, k + 1, visited)
                || dfs(board, i - 1, j, c, k + 1, visited)
                || dfs(board, i, j + 1, c, k + 1, visited)
                || dfs(board, i, j - 1, c, k + 1, visited);

        visited[i][j] = false;
        return isFound;
    }
}