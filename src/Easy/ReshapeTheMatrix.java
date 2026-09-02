package Easy;

import java.util.LinkedList;
import java.util.Queue;

public class ReshapeTheMatrix {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int rows = mat.length;
        int cols = mat[0].length;

        int size = rows * cols;
        int targetSize = r * c;

        if (size != targetSize) {
            return mat;
        }

        Queue<Integer> tmp = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                tmp.add(mat[i][j]);
            }
        }

        int[][] result = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                result[i][j] = tmp.poll();
            }
        }

        return result;
    }
}
