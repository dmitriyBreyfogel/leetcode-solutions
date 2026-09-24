package Medium;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int left = 0;
        for (int num : nums) {
            if (left < 0) left = num;
            else left = Math.max(num, num + left);
            max = Math.max(max, left);
        }
        return max;
    }
}
