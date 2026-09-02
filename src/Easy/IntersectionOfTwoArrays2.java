package Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArrays2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> counts = new HashMap<>();

        for (int num : nums1) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();

        for (int num : nums2) {
            int count = counts.getOrDefault(num, 0);
            if (count > 0) {
                result.add(num);
                counts.put(num, count - 1);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}
