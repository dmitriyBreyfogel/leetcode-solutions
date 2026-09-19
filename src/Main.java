import Easy.BinaryNumberWithAlternatingBits;
import Easy.MaximumAverageSubarray;
import Easy.NumberOfLinesToWriteString;
import Medium.CountAndSay;

public class Main {
    public static void main(String[] args) {
        NumberOfLinesToWriteString test = new NumberOfLinesToWriteString();
        int[] arr = {
                4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10
        };

        String s = "bbbcccdddaaa";
        test.numberOfLines(arr, s);
    }
}
