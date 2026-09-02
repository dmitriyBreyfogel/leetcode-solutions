package Medium;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s.isEmpty()) return "";
        if (s.length() <= 2) return s;

        String longestPalindrome = "";
        for (int i = 0; i < s.length(); i++) {
            String first = expand(s, i, i);
            String second = expand(s, i, i + 1);

            if (first.length() > longestPalindrome.length()) longestPalindrome = first;
            if (second.length() > longestPalindrome.length()) longestPalindrome = second;
        }

        return longestPalindrome;
    }

    private String expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return s.substring(left + 1, right);
    }
}
