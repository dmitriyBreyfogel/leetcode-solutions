package Easy;

public class FlippingAnImage {
    public int[][] flipAndInvertImage(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            reverseRow(image, i);
            invertRow(image, i);
        }

        return image;
    }

    private void reverseRow(int[][] image, int row) {
        for (int i = 0; i < image.length / 2; i++) {
            int tmp = image[row][i];
            image[row][i] = image[row][image.length - 1 - i];
            image[row][image.length - 1 - i] = tmp;
        }
    }

    private void invertRow(int[][] image, int row) {
        for (int i = 0; i < image.length; i++) {
            if (image[row][i] == 0) image[row][i] = 1;
            else image[row][i] = 0;
        }
    }
}
