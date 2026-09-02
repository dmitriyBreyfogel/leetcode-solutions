package Easy;

public class Base7 {
    public String convertToBase7(int num) {
        StringBuilder result = new StringBuilder();
        boolean negative = false;

        if (num == 0) {
            return "0";
        }

        if (num < 0) {
            num = -num;
            negative = true;
        }

        while (num > 0) {
            result.append(num % 7);
            num /= 7;
        }

        if (negative) {
            result.append('-');
        }

        return result.reverse().toString();
    }
}
