package leetcode_problems.easy;

public class FloodFill_733 {

    // Time complexity: O(n+m). Space complexity: O(n)
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        color(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    private void color(int[][] image, int i, int j, int currColor, int newColor) {
        if (i >= image.length || i < 0 || j >= image[i].length || j < 0 || image[i][j] == newColor || image[i][j] != currColor) {
            return;
        }

        image[i][j] = newColor;

        color(image, i - 1, j, currColor, newColor);
        color(image, i, j + 1, currColor, newColor);
        color(image, i + 1, j, currColor, newColor);
        color(image, i, j - 1, currColor, newColor);
    }
}
