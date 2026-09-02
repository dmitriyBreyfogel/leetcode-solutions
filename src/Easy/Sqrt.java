package Easy;

public class Sqrt {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }

        int left = 0;
        int right = x;
        int tmp = 0;

        while (left != right) {
            int mid = left + (right - left) / 2;
            long square = (long) mid * mid;

            if (square == x) {
                return mid;
            }
            else if (square < x) {
                System.out.println(mid);
                tmp = mid;
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }

        return tmp;
    }
}
