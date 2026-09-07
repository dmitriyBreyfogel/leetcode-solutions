package Easy;

public class LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 1) return 1;

        int len = nums.length;
        int count = 1;
        int maxCount = 0;
        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i - 1]) {
                count++;
            }
            else {
                count = 1;
            }

            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }
}
