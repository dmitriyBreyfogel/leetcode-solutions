package Easy;

public class RotateString {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;

        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (goal.equals(shift(chars)))  return true;
        }

        return false;
    }

    private String shift(char[] chars) {
        char last = chars[chars.length - 1];
        for (int i = chars.length - 1; i > 0; i--) {
            chars[i] = chars[i - 1];
        }
        chars[0] = last;
        return new String(chars);
    }
}
