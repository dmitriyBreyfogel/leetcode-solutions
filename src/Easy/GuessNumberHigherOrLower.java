package Easy;

public class GuessNumberHigherOrLower {
    public int guessNumber(int n) {
        int start = 1;
        int end = n;

        while (start < end) {
            int mid = start + (end - start) / 2;
            int result = guess(mid);

            if (result == 0) {
                return mid;
            }

            else if (result == 1) {
                start = mid + 1;
            }

            else {
                end = mid;
            }
        }

        return start;
    }

    private int guess(int n) {
        return -1;
    }
}
