package Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RelativeRanks {
    public String[] findRelativeRanks(int[] score) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < score.length; i++) {
            map.put(score[i], i);
        }

        Arrays.sort(score);

        String[] result = new String[score.length];

        for (int i = score.length - 1; i >= 0; i--) {
            int index = map.get(score[i]);

            if (i == score.length - 1) {
                result[index] = "Gold Medal";
                continue;
            }

            if (i == score.length - 2) {
                result[index] = "Silver Medal";
                continue;
            }

            if (i == score.length - 3) {
                result[index] = "Bronze Medal";
                continue;
            }

            result[index] = String.valueOf(score.length - i);
        }

        return result;
    }
}
