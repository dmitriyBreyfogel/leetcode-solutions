package Medium;

public class RotateImage {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        for (int i = 0; i < matrix.length; i++) {
            reverseLine(matrix, i);
        }
    }

    private void transpose(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    private void reverseLine(int[][] matrix, int row) {
        for (int i = 0; i < matrix[row].length / 2; i++) {
            int tmp = matrix[row][i];
            matrix[row][i] = matrix[row][matrix[row].length - i - 1];
            matrix[row][matrix[row].length - i - 1] = tmp;
        }
    }
}
