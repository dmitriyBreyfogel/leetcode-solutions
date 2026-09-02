package Easy;

import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSubsequence {
    public int findLHS(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int maxLen = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            if (map.containsKey(key + 1)) {
                int len = map.get(key) + map.get(key + 1);
                maxLen = Math.max(maxLen, len);
            }
        }

        return maxLen;
    }
}
