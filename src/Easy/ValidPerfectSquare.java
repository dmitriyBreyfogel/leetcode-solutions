package Easy;

public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if (num == 0) {
            return false;
        }

        if (num == 1) {
            return true;
        }

        long start = 1;
        long end = num;

        while (start < end) {
            long mid = start + (end - start) / 2;
            long square = mid * mid;

            if (square > num) {
                end = mid;
            }
            else {
                start = mid + 1;
            }
        }

        start--;
        return start * start == num;
    }
}
