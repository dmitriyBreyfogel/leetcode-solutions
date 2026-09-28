package Easy;

public class ReverseOnlyLetters {
    public String reverseOnlyLetters(String s) {
        int j = s.length() - 1;
        char[] chars = s.toCharArray();
        int i = 0;
        while (i < j) {
            if (!isAlpha(chars[i])) {
                i++;
                continue;
            }

            if (!isAlpha(chars[j])) {
                j--;
                continue;
            }

            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;

            i++;
            j--;
        }

        return new String(chars);
    }

    private boolean isAlpha(char c) {
        return c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z';
    }
}
