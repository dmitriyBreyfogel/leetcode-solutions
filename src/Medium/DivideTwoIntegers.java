package Medium;

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

        long left = Math.abs((long) dividend);
        long right = Math.abs((long) divisor);

        long result = 0;

        while (left >= right) {
            long temp = right;
            long multiple = 1;

            while (left >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }

            left -= temp;
            result += multiple;
        }

        if ((dividend < 0) ^ (divisor < 0)) {
            result = -result;
        }

        if (result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        if (result > Integer.MAX_VALUE) return Integer.MAX_VALUE;

        return (int) result;
    }
}
