package Easy;

public class ToLowerCase {
    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (isUpperCase(c)) {
                sb.append(toLowerCase(c));
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    private char toLowerCase(char c) {
        return (char) (c + ('a' - 'A'));
    }

    private boolean isUpperCase(char c) {
        return c >= 'A' && c <= 'Z';
    }
}
