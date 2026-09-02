package Easy;

public class AddDigits {
    public int addDigits(int num) {
        int sum = sum(num);

        if (sum < 9) {
            return sum;
        }

        return addDigits(sum);
    }

    private int sum(int num) {
        int sum = 0;

        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }
}
