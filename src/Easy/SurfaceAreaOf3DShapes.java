package Easy;

public class SurfaceAreaOf3DShapes {
    public int surfaceArea(int[][] grid) {
        int n = grid.length;
        int area = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int h = grid[i][j];
                if (h == 0) continue;

                area += 2;

                int left  = (j > 0)     ? grid[i][j - 1] : 0;
                int right = (j < n - 1) ? grid[i][j + 1] : 0;
                int up    = (i > 0)     ? grid[i - 1][j] : 0;
                int down  = (i < n - 1) ? grid[i + 1][j] : 0;

                area += Math.max(0, h - left);
                area += Math.max(0, h - right);
                area += Math.max(0, h - up);
                area += Math.max(0, h - down);
            }
        }
        return area;
    }
}
