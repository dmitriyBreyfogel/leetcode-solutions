package Medium;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {
    private static final String[] LETTERS = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        build(digits, 0, "", result);
        return result;
    }

    private void build(String digits, int index, String current, List<String> result) {
        if (digits.length() == current.length()) {
            result.add(current);
            return;
        }

        String letters = LETTERS[digits.charAt(index) - '0'];

        for (char c : letters.toCharArray()) {
            build(digits, index + 1, current + c, result);
        }
    }
}
