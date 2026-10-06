package Easy;

import java.util.Arrays;

public class MaximizeSumOfArrayAfterKNegations {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (k > 0) {
                if (nums[i] < 0) {
                    nums[i] = -nums[i];
                    k--;
                }
            }
            else break;
        }

        if (k % 2 == 1) {
            int minIndex = 0;
            for (int i = 1; i < n; i++) {
                if (nums[i] < nums[minIndex]) minIndex = i;
            }
            nums[minIndex] = -nums[minIndex];
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        return sum;
    }
}
