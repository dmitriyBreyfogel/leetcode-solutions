package Easy;

import java.util.ArrayList;
import java.util.List;

public class AddToArrayFormOfInteger {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> result = new ArrayList<>();
        int i = num.length - 1;
        int carry = 0;

        while (i >= 0 || k > 0 || carry > 0) {
            int digitNum = (i >= 0) ? num[i] : 0;
            int digitK = k % 10;
            int sum = digitNum + digitK + carry;

            result.add(sum % 10);
            carry = sum / 10;

            k /= 10;
            i--;
        }

        return result.reversed();
    }
}
