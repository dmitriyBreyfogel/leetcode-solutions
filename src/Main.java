import Easy.*;
import Medium.CountAndSay;
import Medium.Search2DMatrix;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {21, 22, 24, 30},
        };

        Search2DMatrix test = new Search2DMatrix();
        test.searchMatrix(matrix, 16);
    }
}
