import Easy.*;
import Medium.CountAndSay;

public class Main {
    public static void main(String[] args) {
        FlippingAnImage test = new FlippingAnImage();
        int[][] nums = {
                {1, 1, 0},
                {1, 0, 1},
                {0, 0, 0}
        };

        test.flipAndInvertImage(nums);
    }
}
