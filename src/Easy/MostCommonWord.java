package Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> map = new HashMap<>();

        String[] words = paragraph.toLowerCase().split("[^a-z]+");
        int maxCount = 0;
        String maxCountString = "";
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);

            if (!isBanned(word, banned)) {
                if (map.get(word) > maxCount) {
                    maxCount = map.get(word);
                    maxCountString = word;
                }
            }
        }

        return maxCountString;
    }

    private boolean isBanned(String word, String[] banned) {
        for (String bannedWord : banned) {
            if (bannedWord.equals(word)) {
                return true;
            }
        }
        return false;
    }
}
