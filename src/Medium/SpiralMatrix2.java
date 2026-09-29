package Medium;

public class SpiralMatrix2 {
    public int[][] generateMatrix(int n) {
        if (n <= 0) return new int[0][0];

        int[][] matrix = new int[n][n];

        // Start from the top-left corner of the matrix with initial value 1
        int[] start = {0, 0};
        int init = 1;

        // Keep filling layers until we reach the center of the matrix
        while (start[0] <= matrix.length / 2) {
            // Fill the current layer spirally
            init = circle(matrix, start, init);

            // Move inward to the next layer
            start[0]++;
            start[1]++;
        }

        return matrix;
    }

    /**
     * Spirally fills one layer (ring) of the matrix.
     * @param matrix the matrix to fill
     * @param start indices of the cell where filling starts (top-left of the layer)
     * @param initValue value to start filling from
     * @return the value the filling stopped at (next unused counter)
     */
    private int circle(int[][] matrix, int[] start, int initValue) {
        int startRow = start[0];
        int startCol = start[1];

        int len = matrix.length;

        // Indices of the bottom-right corner of the current layer
        int endRow = len - 1 - startRow;
        int endCol = len - 1 - startCol;

        // Fill the top edge
        for (int i = startCol; i <= endCol; i++) matrix[startRow][i] = initValue++;

        // Fill the right edge
        for (int i = startRow + 1; i <= endRow; i++) matrix[i][endCol] = initValue++;

        // Fill the bottom edge
        for (int i = endCol - 1; i >= startCol; i--) matrix[endRow][i] = initValue++;

        // Fill the left edge
        for (int i = endRow - 1; i > startRow; i--) matrix[i][startCol] = initValue++;

        return initValue;
    }
}
