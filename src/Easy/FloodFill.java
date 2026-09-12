package Easy;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        if(originalColor == color) return image;

        fill(image, sr, sc, originalColor, color);

        return image;
    }

    private void fill(int[][] image, int sr, int sc, int original, int color) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[sr].length) return;
        if (image[sr][sc] != original) return;

        image[sr][sc] = color;

        fill(image, sr - 1, sc, original, color);
        fill(image, sr + 1, sc, original, color);
        fill(image, sr, sc - 1, original, color);
        fill(image, sr, sc + 1, original, color);
    }
}
