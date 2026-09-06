package Medium;

import java.util.Arrays;

public class TreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int n = nums.length;
        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < n; i++) {
            int start = i + 1, end = n - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (Math.abs(sum - target) < Math.abs(result - target)) result = sum;
                if (sum == target) return sum;
                else if (sum < target) start++;
                else end--;
            }
        }

        return result;
    }
}
