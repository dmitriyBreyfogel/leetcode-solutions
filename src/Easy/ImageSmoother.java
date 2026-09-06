package Easy;

public class ImageSmoother {
    public int[][] imageSmoother(int[][] img) {
        int rows = img.length;
        int cols = img[0].length;

        int[][] result = new int[rows][cols];

        for (int i = 0; i < img.length; i++) {
            for (int j = 0; j < img[i].length; j++) {
                result[i][j] = smoothedValueAt(img, i, j);
            }
        }

        return result;
    }

    private int smoothedValueAt(int[][] img, int x, int y) {
        int rows = img.length;
        int cols = img[0].length;

        int value = img[x][y];

        int left = y != 0 ? img[x][y - 1] : -1;
        int right = y != cols - 1 ? img[x][y + 1] : -1;
        int top = x != 0 ? img[x - 1][y] : -1;
        int bottom = x != rows - 1 ? img[x + 1][y] : -1;

        int leftUp = y != 0 && x != 0 ? img[x - 1][y - 1] : -1;
        int rightUp = y != cols - 1 && x != 0 ? img[x - 1][y + 1] : -1;
        int leftDown = y != 0 && x != rows - 1 ? img[x + 1][y - 1] : -1;
        int rightDown = y != cols - 1 && x != rows - 1 ? img[x + 1][y + 1] : -1;

        int[] neighbors = {
                left, right, top, bottom,
                leftUp, rightUp, leftDown, rightDown
        };

        int sum = value;
        int count = 1;
        for (int num : neighbors) {
            if (num != -1) {
                sum += num;
                count++;
            }
        }

        return sum / count;
    }
}
