package Easy;

import java.util.HashSet;
import java.util.Set;

public class UniqueMorseCodeWordsEasyTopics {
    String[] morseAlphabet = {
            ".-","-...","-.-.","-..",".",
            "..-.","--.","....","..",".---",
            "-.-",".-..","--","-.","---",
            ".--.","--.-",".-.","...","-",
            "..-","...-",".--","-..-","-.--",
            "--.."
    };

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<>();
        for (String word : words) {
            StringBuilder convert = new StringBuilder();
            for (char ch : word.toCharArray()) {
                convert.append(morseAlphabet[ch - 'a']);
            }

            set.add(convert.toString());
        }

        return set.size();
    }
}
