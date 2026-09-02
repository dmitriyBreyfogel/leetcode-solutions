package Easy;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        if (x == 0) {
            return true;
        }

        if (x % 10 == 0) {
            return false;
        }

        int reverse = 0;
        int tmp = x;

        while (tmp > 0) {
            reverse = reverse * 10 + tmp % 10;
            tmp = tmp / 10;
        }

        return x == reverse;
    }
}
