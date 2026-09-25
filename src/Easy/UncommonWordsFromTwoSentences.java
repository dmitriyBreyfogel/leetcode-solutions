package Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UncommonWordsFromTwoSentences {
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] s1Words = s1.split(" ");
        String[] s2Words = s2.split(" ");
        List<String> result = new ArrayList<>();

        Map<String, Integer> mapS1 = new HashMap<>();
        for (String word : s1Words) {
            mapS1.put(word, mapS1.getOrDefault(word, 0) + 1);
        }

        Map<String, Integer> mapS2 = new HashMap<>();
        for (String word : s2Words) {
            mapS2.put(word, mapS2.getOrDefault(word, 0) + 1);
        }

        for(Map.Entry<String, Integer> entry : mapS1.entrySet()) {
            if (entry.getValue() > 1) continue;
            else {
                if (!mapS2.containsKey(entry.getKey())) {
                    result.add(entry.getKey());
                }
            }
        }

        for (Map.Entry<String, Integer> entry : mapS2.entrySet()) {
            if (entry.getValue() > 1) continue;
            else {
                if (!mapS1.containsKey(entry.getKey())) {
                    result.add(entry.getKey());
                }
            }
        }

        return result.toArray(new String[0]);
    }
}
