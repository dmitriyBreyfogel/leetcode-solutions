package Easy;

import java.util.ArrayList;
import java.util.List;

public class ReverseVowelsOfString {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        List<Character> vowels = new ArrayList<>();

        for (char c : chars) {
            if (isVowel(c)) {
                vowels.add(c);
            }
        }

        int index = vowels.size() - 1;

        for (int i = 0; i < chars.length; i++) {
            if (isVowel(chars[i])) {
                chars[i] = vowels.get(index--);
            }
        }

        return new String(chars);
    }

    private boolean isVowel(char c) {
        String vowels = "aeiouAEIOU";
        return vowels.contains(String.valueOf(c));
    }
}
