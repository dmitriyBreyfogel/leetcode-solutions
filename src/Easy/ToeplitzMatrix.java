package Easy;

public class ToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i < matrix[0].length - 1; i++) {
            if (!isValidDiagonal(matrix, 0, i)) return false;
        }

        for (int i = 0; i < matrix.length - 1; i++) {
            if (!isValidDiagonal(matrix, i, 0)) return false;
        }

        return true;
    }

    private boolean isValidDiagonal(int[][] matrix, int row, int col) {
        int value = matrix[row][col];
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = row + 1; i < rows; i++) {
            if (col < cols - 1) {
                if (matrix[i][col + 1] != value) return false;
            }
            col++;
        }

        return true;
    }
}
