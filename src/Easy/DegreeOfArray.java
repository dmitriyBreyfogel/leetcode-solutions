package Easy;

import java.util.HashMap;
import java.util.Map;

public class DegreeOfArray {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer[]> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new Integer[]{i, i, 1});
            } else {
                Integer[] data = map.get(nums[i]);
                data[1] = i;   // обновляем последний индекс
                data[2]++;     // увеличиваем количество
            }
        }

        int max = 0;
        for (Map.Entry<Integer, Integer[]> entry : map.entrySet()) {
            max = Math.max(max, entry.getValue()[2]);
        }

        int min = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer[]> entry : map.entrySet()) {
            if (entry.getValue()[2] == max) {
                Integer[] data = entry.getValue();
                min = Math.min(data[1] - data[0] + 1, min);
            }
        }

        return min;
    }
}
