package Easy;

import java.util.ArrayList;
import java.util.List;

public class KeyboardRow {
    public String[] findWords(String[] words) {
        List<String> result = new ArrayList<>();

        for (String word : words) {
            if (canType(word)) {
                result.add(word);
            }
        }

        return result.toArray(new String[0]);
    }

    private boolean canType(String word) {
        String FIRST_ROW = "qwertyuiop";
        String SECOND_ROW = "asdfghjkl";
        String THIRD_ROW = "zxcvbnm";

        String normalizedWord = word.toLowerCase();

        char c = normalizedWord.charAt(0);

        if (FIRST_ROW.contains(String.valueOf(c))) {
            return wordFromOneRowKeyboard(normalizedWord, FIRST_ROW);
        }
        else if (SECOND_ROW.contains(String.valueOf(c))) {
            return wordFromOneRowKeyboard(normalizedWord, SECOND_ROW);
        }
        else {
            return wordFromOneRowKeyboard(normalizedWord, THIRD_ROW);
        }
    }

    private boolean wordFromOneRowKeyboard(String word, String symbolsKeyboardRow) {
        for (char c : word.toCharArray()) {
            if (!symbolsKeyboardRow.contains(String.valueOf(c))) {
                return false;
            }
        }

        return true;
    }
}
