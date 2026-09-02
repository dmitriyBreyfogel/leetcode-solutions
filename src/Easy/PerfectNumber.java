package Easy;

import java.util.ArrayList;
import java.util.List;

public class PerfectNumber {
    public boolean checkPerfectNumber(int num) {
        int[] divisors = getDivisors(num);

        int sum = 0;
        for (int tmp : divisors) {
            sum += tmp;
        }

        return sum == num;
    }

    private int[] getDivisors(int num) {
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                result.add(i);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}
