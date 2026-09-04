package Medium;

public class ReverseInteger {
    public int reverse(int x) {
        String s = Integer.toString(x);

        boolean negative = false;
        if (s.charAt(0) == '-') negative = true;

        if (negative) s = s.substring(1);

        StringBuilder res = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            res.append(s.charAt(i));
        }

        long reversed = Long.parseLong(res.toString());

        if (reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE) return 0;

        if (negative) reversed *= -1;

        return (int) reversed;
    }
}
