package Medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        int row1 = 0;
        int col1 = 0;
        int row2 = matrix.length - 1;
        int col2 = matrix[0].length - 1;

        while (row1 <= row2 && col1 <= col2) {
            circle(result, matrix, row1, col1, row2, col2);

            row1++;
            col1++;
            row2--;
            col2--;
        }

        return result;
    }

    private void circle(List<Integer> result, int[][] matrix, int row1, int col1, int row2, int col2) {
        for (int i = col1; i <= col2; i++) {
            result.add(matrix[row1][i]);
        }

        for (int i = row1 + 1; i <= row2; i++) {
            result.add(matrix[i][col2]);
        }

        if (row1 < row2) {
            for (int i = col2 - 1; i >= col1; i--) {
                result.add(matrix[row2][i]);
            }
        }

        if (col1 < col2) {
            for (int i = row2 - 1; i > row1; i--) {
                result.add(matrix[i][col1]);
            }
        }
    }
}
