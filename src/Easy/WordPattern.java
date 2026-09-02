package Easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        char[] patternArray = pattern.toCharArray();
        String[] words = s.split(" ");

        if (patternArray.length != words.length) {
            return false;
        }

        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();

        for (int i = 0; i < patternArray.length; i++) {
            if (charToWord.containsKey(patternArray[i]) && !Objects.equals(charToWord.get(patternArray[i]), words[i])) {
                return false;
            }

            if (wordToChar.containsKey(words[i]) && !Objects.equals(wordToChar.get(words[i]), patternArray[i])) {
                return false;
            }

            charToWord.put(patternArray[i], words[i]);
            wordToChar.put(words[i], patternArray[i]);
        }

        return true;
    }
}
