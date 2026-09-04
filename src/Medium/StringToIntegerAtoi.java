package Medium;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringToIntegerAtoi {
    public int myAtoi(String s) {
        Pattern pattern = Pattern.compile("^\\s*([+-]?\\d+)");
        Matcher matcher = pattern.matcher(s);

        if (!matcher.find()) return 0;

        String str = matcher.group(1);
        long result = 0;

        boolean negative = false;
        int i = 0;
        if (str.charAt(0) == '+' || str.charAt(0) == '-') {
            negative = str.charAt(0) == '-';
            i = 1;
        }

        while (i < str.length()) {
            result = result * 10 + (str.charAt(i) - '0');

            if (negative && -result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            if (!negative && result > Integer.MAX_VALUE) return Integer.MAX_VALUE;

            i++;
        }

        return (int) (negative ? -result : result);
    }
}
