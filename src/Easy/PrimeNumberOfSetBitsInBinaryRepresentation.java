package Easy;

public class PrimeNumberOfSetBitsInBinaryRepresentation {
    public int countPrimeSetBits(int left, int right) {
        int result = 0;
        for (int i = left; i <= right; i++) {
            String binary = Integer.toBinaryString(i);

            int count = 0;
            for (char ch : binary.toCharArray()) {
                if (ch == '1') count++;
            }
            if (isPrime(count)) result++;
        }

        return result;
    }

    private boolean isPrime(int num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;

        int sqrt = (int) Math.sqrt(num);
        for (int i = 3; i <= sqrt; i += 2) {
            if (num % i == 0) return false;
        }

        return true;
    }
}
