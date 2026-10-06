package Medium;

public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int top = 0, bottom = rows - 1;
        while (top <= bottom) {
            int mid = top + (bottom - top) / 2;
            if (matrix[mid][0] <= target) {
                top = mid + 1;
            } else {
                bottom = mid - 1;
            }
        }
        int row = bottom;
        if (row < 0) return false;

        int left = 0, right = cols - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[row][mid] == target) return true;
            if (matrix[row][mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
}
