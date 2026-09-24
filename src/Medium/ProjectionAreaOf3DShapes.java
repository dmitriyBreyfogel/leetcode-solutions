package Medium;

public class ProjectionAreaOf3DShapes {
    public int projectionArea(int[][] grid) {
        int n = grid.length;

        int xy = 0;
        for (int[] value : grid) {
            for (int num : value) {
                if (num != 0) xy++;
            }
        }

        int xz = 0;
        for (int[] ints : grid) {
            xz += max(ints);
        }

        int zy = 0;
        for (int j = 0; j < n; j++) {
            int[] col = new int[n];
            for (int i = 0; i < n; i++) {
                col[i] = grid[i][j];
            }

            zy += max(col);
        }

        return xy + xz + zy;
    }

    private int max(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }

        return max;
    }
}
