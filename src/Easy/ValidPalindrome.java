package Easy;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        String text = s.replaceAll("[^a-zA-Zа-яёА-ЯЁ0-9\\s]", "").toLowerCase();

        for (int i = 0; i < text.length(); i++) {
            if (i == text.length() - i - 1) {
                break;
            }

            if (text.charAt(i) != text.charAt(text.length() - i - 1)) {
                return false;
            }
        }

        return true;
    }
}
