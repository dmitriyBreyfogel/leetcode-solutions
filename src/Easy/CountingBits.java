package Easy;

public class CountingBits {
    public int[] countBits(int n) {
        int[] counts = new int[n + 1];

        int i = 0;
        while (i <= n) {
            counts[i] = countBitsHelper(i);
            i++;
        }

        return counts;
    }

    private int countBitsHelper(int n) {
        int count = 0;

        while (n > 0) {
            if (n % 2 == 1) count++;
            n = n / 2;
        }

        return count;
    }
}
