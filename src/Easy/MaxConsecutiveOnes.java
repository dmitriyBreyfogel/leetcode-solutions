package Easy;

public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = Integer.MIN_VALUE;
        int count = 0;

        for (int num : nums) {
            if (num == 1) {
                count++;
            }

            if (num == 0) {
                max = Math.max(max, count);
                count = 0;
            }
        }

        max = Math.max(max, count);
        return max;
    }
}
