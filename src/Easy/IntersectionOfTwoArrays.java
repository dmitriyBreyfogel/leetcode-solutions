package Easy;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return new int[0];
        }

        Set<Integer> set1 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }

        Set<Integer> resultSet = new HashSet<>();
        for (int i : nums2) {
            if (set1.contains(i)) {
                resultSet.add(i);
            }
        }

        int[] result = new int[resultSet.size()];
        int j = 0;
        for (int i : resultSet) {
            result[j++] = i;
        }

        return result;
    }
}
